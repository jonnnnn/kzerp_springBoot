/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.data.IBaseModel;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.fin.dao.PayrecDao;
import com.imema.modules.fin.entity.PayrecEntity;
import com.imema.modules.fin.service.PayrecService;
import com.imema.modules.pur.entity.PoHeaderEntity;
import com.imema.modules.so.entity.SalesOrderEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("payrecService")
public class PayrecServiceImpl extends BaseServiceImpl<PayrecDao, PayrecEntity> implements PayrecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        Map<String, Object> selectFrom = (Map<String, Object>) dataForm.get("data");

        IPage<PayrecEntity> page = baseMapper.queryPage(
                new Query<PayrecEntity>().getPage(pageForm),
                selectFrom
        );

        return new PageUtils(page);
    }

    /**
     * 创建财务收款
     * @param obj
     * @param orderEnum
     * @return
     */
    @Override
    public R createrPayrec(Object obj, OrderEnum orderEnum) {
        PayrecEntity payrecEntity = new PayrecEntity();
        payrecEntity.setSourceOrderType(orderEnum.getvalue());
        payrecEntity.setOrderDate(new Date());
        payrecEntity.setStatus(OrderEnum.FIN_UNPAID.getvalue());
        payrecEntity.setPic("");

        switch (orderEnum){
            case SO:
            case SO_RETURN:
                SalesOrderEntity so = (SalesOrderEntity) obj;
                payrecEntity.setAmount(so.getOrderAmount());
                payrecEntity.setType(orderEnum.equals(OrderEnum.SO)?"应收款":"应付款");
                payrecEntity.setSourceOrderId(so.getId());
                payrecEntity.setSourceOrderNum(so.getOrderNum());
                payrecEntity.setCustId(so.getCustomerId());
                payrecEntity.setCompanyId(so.getCompanyId());
                break;
            case PO:
            case PO_RETURN:
                IBaseModel iBaseModel=(IBaseModel)obj;

                payrecEntity.setAmount(((BigDecimal)iBaseModel.get("currentAmount")).negate());//本次采购入库的单据金额
                payrecEntity.setType(orderEnum.equals(OrderEnum.PO)?"应付款":"应收款");
                payrecEntity.setSourceOrderId((Integer) iBaseModel.get("id"));
                payrecEntity.setSourceOrderNum((String)iBaseModel.get("orderNum"));
                payrecEntity.setCustId((Integer) iBaseModel.get("vendorId"));
                payrecEntity.setCompanyId((Integer) iBaseModel.get("companyId"));
                //拣货单ID
                payrecEntity.setSourcePickId((Integer)iBaseModel.get("pickId"));

                //创建运费
                if(StringUtils.isEmpty(iBaseModel.get("payType")) || StringUtils.isEmpty(iBaseModel.get("freight")))
                    break;

                String payType = iBaseModel.get("payType")+"";
                BigDecimal freight = (BigDecimal) iBaseModel.get("freight");//本地运费
                Integer shipId = null;
                if(!StringUtils.isEmpty(iBaseModel.get("shipId")))
                    shipId = (Integer)iBaseModel.get("shipId");

                if("WF_NOW".equals(payType)){
                    PayrecEntity payrecEntityShip = this.createShipGagthering(orderEnum,iBaseModel);
                    payrecEntityShip.setAmount(freight.negate());
                    payrecEntityShip.setType("应付款");
                    payrecEntityShip.setCustId(shipId);
                    payrecEntityShip.setRemark("运费");
                    this.save(payrecEntityShip);
                }else if("WF_DFDF".equals(payType)){
                    PayrecEntity payrecEntityShip = this.createShipGagthering(orderEnum,iBaseModel);
                    payrecEntityShip.setAmount(freight.negate());
                    payrecEntityShip.setType("应付款");
                    payrecEntityShip.setCustId((Integer) iBaseModel.get("vendorId"));
                    payrecEntityShip.setRemark("运费-对方代付");
                    this.save(payrecEntityShip);
                }else if("DF_WFDF".equals(payType)){
                    PayrecEntity payrecEntityShip = this.createShipGagthering(orderEnum,iBaseModel);
                    payrecEntityShip.setAmount(freight.negate());
                    payrecEntityShip.setType("应付款");
                    payrecEntityShip.setCustId(shipId);
                    payrecEntityShip.setRemark("运费-我方代付");
                    this.save(payrecEntityShip);

                    PayrecEntity payrecEntityShip2 = this.createShipGagthering(orderEnum,iBaseModel);
                    payrecEntityShip2.setAmount(freight);
                    payrecEntityShip2.setType("应收款");
                    payrecEntityShip2.setCustId((Integer) iBaseModel.get("vendorId"));
                    payrecEntityShip2.setRemark("运费-我方代付");
                    this.save(payrecEntityShip2);

                }

                break;
            default:
                break;
        }
        this.save(payrecEntity);
        return R.ok();
    }

    public PayrecEntity createShipGagthering(OrderEnum orderEnum,IBaseModel iBaseModel){
        PayrecEntity payrecEntity = new PayrecEntity();
        payrecEntity.setSourceOrderType(OrderEnum.FREIGHT.getvalue());
        payrecEntity.setOrderDate(new Date());
        payrecEntity.setStatus(OrderEnum.FIN_UNPAID.getvalue());
        payrecEntity.setPic("");
        payrecEntity.setSourceOrderId((Integer) iBaseModel.get("id"));
        payrecEntity.setSourceOrderNum((String)iBaseModel.get("orderNum"));
        payrecEntity.setCompanyId((Integer) iBaseModel.get("companyId"));
        //拣货单ID
        payrecEntity.setSourcePickId((Integer)iBaseModel.get("pickId"));
        return payrecEntity;
    }


    /**
     * 取消收款
     * @param obj
     * @param orderEnum
     * @return
     */
    @Override
    public R cancelPayrec(Object obj, OrderEnum orderEnum) {

        switch (orderEnum){
            case SO:
            case SO_RETURN:

                break;
            case PO:
            case PO_RETURN:
                IBaseModel iBaseModel=(IBaseModel)obj;
                QueryWrapper<PayrecEntity> queryWrapper = new QueryWrapper<>();
//                queryWrapper.eq("SOURCE_ORDER_TYPE", orderEnum.getvalue());
                queryWrapper.eq("SOURCE_ORDER_ID", (Integer) iBaseModel.get("id"));
                queryWrapper.eq("SOURCE_PICK_ID", (Integer) iBaseModel.get("pickId"));
                queryWrapper.eq("STATUS", "PAID");

                Integer count = this.baseMapper.selectCount(queryWrapper);
                if(count>0){
                    return R.error("该采购单部分财务单据已经收款,如需继续操作,请先删除对应的收款单.");
                }

                Map<String,Object> columnMap = new HashMap<>();
//                columnMap.put("SOURCE_ORDER_TYPE", orderEnum.getvalue());
                columnMap.put("SOURCE_ORDER_ID", (Integer) iBaseModel.get("id"));
                columnMap.put("SOURCE_PICK_ID", (Integer) iBaseModel.get("pickId"));
                columnMap.put("STATUS", "UNPAID");

                //删除财务单据
                this.baseMapper.deleteByMap(columnMap);
                break;
            default:
                break;
        }
        return R.ok();
    }
}