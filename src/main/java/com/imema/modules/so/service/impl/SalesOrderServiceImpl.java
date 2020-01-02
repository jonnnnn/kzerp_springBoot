/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.annotation.DataFilter;
import com.imema.common.enums.EntityState;
import com.imema.common.utils.*;
import com.imema.common.validator.ValidatorUtils;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.entity.MtlProduct;
import com.imema.modules.base.service.MtlProductService;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.fin.service.PayrecService;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.service.InoutBillService;
import com.imema.modules.inv.service.ReservationsService;
import com.imema.modules.so.dao.SalesOrderDao;
import com.imema.modules.so.dao.SalesOrderLineDao;
import com.imema.modules.so.entity.SalesOrderEntity;
import com.imema.modules.so.entity.SalesOrderLineEntity;
import com.imema.modules.so.service.SalesOrderLineService;
import com.imema.modules.so.service.SalesOrderService;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;


@Service("salesOrderService")
public class SalesOrderServiceImpl extends BaseServiceImpl<SalesOrderDao, SalesOrderEntity> implements SalesOrderService {

    @Autowired
    public SalesOrderLineService salesOrderLineService;
    @Autowired
    public SalesOrderLineDao salesOrderLineDao;
    @Autowired
    public MtlProductService mtlProductService;
    @Autowired
    public InoutBillService inoutBillService;
    @Autowired
    public ReservationsService reservationsService;
    @Autowired
    public PayrecService payrecService;

    @Override
    @DataFilter(subDept = true, user = false, tableAlias = "a")
    public PageUtils queryOrder(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        Map<String, Object> selectFrom = (Map<String, Object>) dataForm.get("data");

        //物料ID
        if(selectFrom != null && selectFrom.containsKey("productName") && objIsNotBlank(selectFrom.get("productName"))){
            String productIds = mtlProductService.searchProductIds(selectFrom.get("productName")+"");
            selectFrom.put("productIds",productIds);
        }


        IPage<SalesOrderEntity> page = baseMapper.orderList(
                new Query<SalesOrderEntity>().getPage(pageForm),
                selectFrom);

        return new PageUtils(page);
    }

    @Override
    public List<Map<String, Object>> getProduct(Map<String, Object> params){
        return baseMapper.getProduct(params);
    }

    @Override
    public List<Map<String, Object>> getCustVender(Map<String, Object> params){
        return baseMapper.getCustVender(params);
    }


    @Override
    @Transactional
    public R saveOrder(SalesOrderEntity orderEntity) {
        boolean isReturn = false;
        if(isNewObj(orderEntity)){
            orderEntity.setStatus("NEW");
            orderEntity.setPic(ShiroUtils.getUserEntity().getUsername());
            if("RETURN".equals(orderEntity.getOrderType())){
                isReturn = true;
                try {
                    orderEntity.setOrderNum(billnumHelper.getNextNum("SAL_SALES_ORDER_RETURN"));
                } catch (Exception e) {
                    return R.error("单据编号创建异常,保存失败!");
                }
            }

        }
        boolean isOk = this.save(orderEntity);

        if(isOk){
            List<SalesOrderLineEntity> lines = orderEntity.getLineList();
            for (SalesOrderLineEntity line:lines) {
                line.setOrderId(orderEntity.getId());
                ValidatorUtils.validateEntity(line, UpdateGroup.class);
                line.setAmount(line.getPrice().multiply(BigDecimal.valueOf(line.getOrderQty())).setScale(2,BigDecimal.ROUND_HALF_UP));
                salesOrderLineService.save(line);
            }
        }else {
            return R.error("未知异常,保存失败!");
        }

        BigDecimal amount = getTotalAmount(orderEntity.getId());
        if(amount.setScale(2,BigDecimal.ROUND_HALF_UP).compareTo(orderEntity.getOrderAmount().setScale(2,BigDecimal.ROUND_HALF_UP)) != 0){
            //如果金额不一致,从新修改
            orderEntity.setOrderAmount(amount);
            this.updateById(orderEntity);
        }
        //直接提交
        if(!StringUtils.isEmpty(orderEntity.get("isSubmit"))){
            this.submit(orderEntity.getId()+"");
        }
        return R.ok().putData(orderEntity);
    }

    /**
     * 获取单据的订单总金额
     */
    public BigDecimal getTotalAmount(Integer orderId){
        return salesOrderLineDao.getTotalPrice(orderId);
    }




    /**
     * 获取客户的上次销售价
     */
    public void setCustLastPrice(Integer custId, List<MtlProduct> products){
        if(!objIsNotBlank(custId) || products == null){
            return;
        }
        String ids = "-99";
        for (MtlProduct product: products) {
            ids +=","+product.getId();
        }
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",custId);
        param.put("productIds",ids);
        List<Map<String,Object>> priceList = this.baseMapper.getCustLastPrice(param);
        if(priceList != null && priceList.size()>0){
            for (MtlProduct product: products) {
                for (Map<String,Object> priceMap: priceList) {
                    if((product.getId()).equals(priceMap.get("id"))){
                        product.put("lastPrice",priceMap.get("lastPrice"));
                        break;
                    }
                }
            }
        }
    }


    @Override
    @Transactional
    public R submit(String id) {
        //判断可提交状态.
        SalesOrderEntity orderEntity = baseMapper.selectById(id);

        boolean isReturn = false;
        if("RETURN".equals(orderEntity.getOrderType())) isReturn = true;

        if(orderEntity == null || !orderEntity.getStatus().equals(OrderEnum.NEW.getvalue())){//新增状态才可提交
            return R.error("订单状态异常,请刷新页面再提交.");
        }

        //自动分仓,生成可用来创建拣货和保留的对象
        HashMap<Integer,SalesOrderEntity> splitOrders = createStockObj(orderEntity);
        if(orderEntity.isAutoPeaking()){//自动拣货
            for(SalesOrderEntity tempOrder : splitOrders.values()){
                tempOrder.put("isAuto",true);
                //1.调用自动拣货方法
                if(isReturn){
                    inoutBillService.autoCreate(tempOrder,BasicEnum.SO_RETURN_IN);
                }else{
                    inoutBillService.autoCreate(tempOrder,BasicEnum.SO_OUT);
                }

            }

        }else{//手动拣货
            for(SalesOrderEntity tempOrder : splitOrders.values()){
                if(isReturn){
                    //1.创建拣货
                    inoutBillService.autoCreate(tempOrder,BasicEnum.SO_RETURN_IN);
                }else{
                    //1.创建保留
                    tempOrder.put("tranType",BasicEnum.SO_OUT.getValue());
                    reservationsService.add(tempOrder);
                    //2.创建拣货
                    inoutBillService.autoCreate(tempOrder,BasicEnum.SO_OUT);
                }

            }
        }
        //修改订单状态
        orderEntity.setStatus(OrderEnum.SUBMIT.getvalue());
        orderEntity.setState(EntityState.MODIFIED);
        this.save(orderEntity);
        //生成财务应收应付
        payrecService.createrPayrec(orderEntity,isReturn?OrderEnum.SO_RETURN:OrderEnum.SO);
        return null;
    }

    public HashMap<Integer,SalesOrderEntity> createStockObj(SalesOrderEntity orderEntity){
        boolean isReturn = false;
        if("RETURN".equals(orderEntity.getOrderType())) isReturn = true;

        String sql = "select PRODUCT_ID as productId,sum(ORDER_QTY) qty,price " +
                "   from sal_sales_order_line where ORDER_ID = "+orderEntity.getId()+" and ORDER_QTY != 0 group by PRODUCT_ID,price";
        List<LinkedHashMap<String ,Object>> list = commonDao.getListBySql(sql);
        HashMap<Integer,SalesOrderEntity> resMap = new HashMap<>();
        for (LinkedHashMap<String ,Object> lineMap: list) {
            Integer orderQty = Integer.valueOf(lineMap.get("qty")+"");
            //查询每个物料的所有库存
            sql = "select COMPANY_ID as companyId,WAREHOUSE_ID as whId,Qty as qty" +
                    " from v_prod_wh_stock where PRODUCT_ID = "+lineMap.get("productId")+" and COMPANY_ID = "+ShiroUtils.getCompanyId() +" order by qty";
            List<LinkedHashMap<String ,Object>> stockList = commonDao.getListBySql(sql);
            for (LinkedHashMap<String ,Object> stockMap: stockList) {
                SalesOrderEntity saleEntity = null;
                List<SalesOrderLineEntity> saleLines = null;
                Integer whId = (Integer) stockMap.get("whId");
                Integer stockQty = Integer.valueOf(lineMap.get("qty")+"");
                if(resMap.containsKey(whId)){
                    saleEntity = resMap.get(whId);
                    saleLines = saleEntity.getLineList();
                }else{
                    saleEntity = new SalesOrderEntity();
                    BeanUtils.copyProperties(orderEntity,saleEntity);
                    saleEntity.setWarehouseId(whId);
                    saleLines = new ArrayList<SalesOrderLineEntity>();
                    saleEntity.setLineList(saleLines);
                    resMap.put(whId,saleEntity);
                }

                SalesOrderLineEntity lineEntity = new SalesOrderLineEntity();
                lineEntity.setOrderId(saleEntity.getId());
                lineEntity.setId(0);
                lineEntity.setProductId((Integer) lineMap.get("productId"));
                lineEntity.put("uom","");
                lineEntity.put("salePrice",new BigDecimal(lineMap.get("price")+""));


                //一行不够的情况.
                if(stockQty < orderQty && !isReturn){
                    orderQty = orderQty-stockQty;
                    lineEntity.setOrderQty(stockQty);
                    saleLines.add(lineEntity);
                }else{
                    lineEntity.setOrderQty(Math.abs(orderQty));
                    saleLines.add(lineEntity);
                    orderQty = 0;
                    break;
                }
            }
            if(orderQty > 0){
                throw new RuntimeException("库存不足!"+lineMap.get("productId"));
            }
            
        }

        return resMap;
    }
}