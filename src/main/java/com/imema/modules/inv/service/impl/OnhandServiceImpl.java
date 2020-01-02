/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.data.DefaultBaseModel;
import com.imema.data.IBaseModel;
import com.imema.modules.base.service.MtlProductPriceService;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.dto.OnhandDto;
import com.imema.modules.dto.OnhandLineDto;
import com.imema.modules.inv.dao.OnhandDao;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.inv.entity.OnhandEntity;
import com.imema.modules.inv.service.OnhandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("onhandService")
public class OnhandServiceImpl extends BaseServiceImpl<OnhandDao, OnhandEntity> implements OnhandService {

    @Autowired
    private MtlProductPriceService mtlProductPriceService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        IPage<OnhandEntity> page = baseMapper.queryPage(new Query<OnhandEntity>().getPage(pageForm),(LinkedHashMap)dataForm.get("data"));
        return new PageUtils(page);
    }

    /**
     * 新增或修改库存
     * @param inoutBillEntity
     * @throws RuntimeException
     */
    @Override
    public void addOrUpdate(InoutBillEntity inoutBillEntity) throws RuntimeException {
        try {
            final List<InoutBillLineEntity> inoutBillLineEntityList = inoutBillEntity.getLineList();
            for (InoutBillLineEntity inoutBillLineEntity : inoutBillLineEntityList) {
                OnhandEntity onhandEntity=getCurrentStock(inoutBillEntity,inoutBillLineEntity);
                BigDecimal avgCostPrice=BigDecimal.ZERO;
                if(onhandEntity==null){
                    onhandEntity=new OnhandEntity();
                    onhandEntity.setCompanyId(inoutBillEntity.getCompanyId());
                    onhandEntity.setProductId(inoutBillLineEntity.getProductId());
                    onhandEntity.setWarehouseId(inoutBillEntity.getWarehouseId());
                    onhandEntity.setUom(inoutBillLineEntity.getUom());
                    onhandEntity.setInventoryQuantity(inoutBillLineEntity.getRealQty());
                    if (inoutBillLineEntity.getCostPrice()!=null)
                        onhandEntity.setPrice(inoutBillLineEntity.getCostPrice());
                    onhandEntity.setCreateBy(inoutBillLineEntity.getCreateBy());
                    onhandEntity.setCreateDate(new Date());
                    inoutBillLineEntity.setPriorQuantity(0);
                    this.save(onhandEntity);
                    if(inoutBillEntity.getTransactionType().equals(BasicEnum.PO_IN.getValue()))avgCostPrice=this.getAvgCostPrice(onhandEntity,inoutBillLineEntity);
                }else{
                    if(inoutBillEntity.getTransactionType().equals(BasicEnum.PO_IN.getValue()))avgCostPrice=this.getAvgCostPrice(onhandEntity,inoutBillLineEntity);
                    inoutBillLineEntity.setPriorQuantity(onhandEntity.getInventoryQuantity().intValue());
                    onhandEntity.setInventoryQuantity(onhandEntity.getInventoryQuantity()+inoutBillLineEntity.getRealQty());
                    if (inoutBillLineEntity.getCostPrice()!=null)
                        onhandEntity.setPrice(inoutBillLineEntity.getCostPrice());
                    onhandEntity.setUpdateBy(inoutBillLineEntity.getCreateBy());
                    onhandEntity.setUpdateDate(new Date());
                    this.updateById(onhandEntity);
                }
                inoutBillLineEntity.setBalanceQuantity(onhandEntity.getInventoryQuantity());
                inoutBillLineEntity.setCostPrice(onhandEntity.getPrice());
                if(inoutBillEntity.getTransactionType().equals(BasicEnum.PO_IN.getValue())){
                    onhandEntity.put("avgCostPrice",avgCostPrice);
                    mtlProductPriceService.addOrUpdate(onhandEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("现有量处理失败！"+e.getMessage());
        }
    }
    private BigDecimal getAvgCostPrice(OnhandEntity onhandEntity,InoutBillLineEntity inoutBillLineEntity){
        BigDecimal oldCostPrice=onhandEntity.getPrice().multiply(new BigDecimal(onhandEntity.getInventoryQuantity()));
        BigDecimal newCostPrice=inoutBillLineEntity.getCostPrice().multiply(new BigDecimal(inoutBillLineEntity.getRealQty()));
        return (oldCostPrice.add(newCostPrice)).divide(new BigDecimal(onhandEntity.getInventoryQuantity()+inoutBillLineEntity.getRealQty()),2);
    }
    /**
     * 根据条件获取当前现有量库存
     * @param iBaseModel
     * @param iBaseModelLine
     * @return
     */
    private OnhandEntity getCurrentStock(final IBaseModel iBaseModel,final IBaseModel iBaseModelLine){
        return this.getOne(setStockParam(iBaseModel,iBaseModelLine));
    }

    private Wrapper<OnhandEntity> setStockParam(final IBaseModel iBaseModel,final IBaseModel iBaseModelLine) {
        return new QueryWrapper<OnhandEntity>().eq("company_id", iBaseModel.get("companyId"))
                .eq("warehouse_id", iBaseModel.get("warehouseId"))
                .eq("product_id",iBaseModelLine.get("productId"));
    }

    /**
     * 根据条件获取当前可用量库存
     * @param iBaseModel
     * @param iBaseModelLine
     * @return
     */
    private DefaultBaseModel getCurrentValStock(final IBaseModel iBaseModel, final IBaseModel iBaseModelLine){
        return baseMapper.getCurrentValStock(iBaseModel,iBaseModelLine);
    }


    /**
     * 校验可用量
     * @param objectClass
     * @return
     */
    @Override
    public void valOnhand(final Object objectClass) throws RuntimeException {
        IBaseModel iBaseModel=(IBaseModel)objectClass;
        List<Object> objLineList=((List)iBaseModel.get("lineList"));
        for (Object objLine : objLineList) {
            IBaseModel iBaseModelLine=(IBaseModel)objLine;
            DefaultBaseModel defaultBaseModel=getCurrentValStock(iBaseModel,iBaseModelLine);
            if(defaultBaseModel==null){
                throw new RuntimeException("库存量不够，请检查数据再次提交! \n数据信息: "+ "仓库="+iBaseModel.get("warehouseCode")+
                        ",物料="+ iBaseModel.get("productCode"));
            }else if(defaultBaseModel!=null){
                Integer _qty=Integer.parseInt(defaultBaseModel.get("qty").toString());
                if(_qty.intValue()<Math.abs((int)iBaseModelLine.get("orderQty"))){
                    throw new RuntimeException("库存量不够，请检查数据再次提交! \n数据信息: "+ "仓库="+iBaseModel.get("warehouseCode")+
                            ",物料="+ iBaseModel.get("productCode"));
                }
            }
        }
    }

}