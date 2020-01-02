/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.service.impl;

import com.imema.common.enums.EntityState;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.pur.dao.PoLineDao;
import com.imema.modules.pur.entity.PoHeaderEntity;
import com.imema.modules.pur.entity.PoLineEntity;
import com.imema.modules.pur.service.PoHeaderService;
import com.imema.modules.pur.service.PoLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service("poLineService")
public class PoLineServiceImpl extends BaseServiceImpl<PoLineDao, PoLineEntity> implements PoLineService {

    @Autowired
    private PoHeaderService poHeaderService;
    @Override
    public void save(PoHeaderEntity poHeaderEntity) throws RuntimeException{
        try {
            List<PoLineEntity> poLineEntityList = poHeaderEntity.getLineList();
            if (poLineEntityList != null) {
                for (PoLineEntity poLineEntity : poLineEntityList) {
                    if (poLineEntity.getState().equals(EntityState.NEW)) {
                        poLineEntity.setOrderId(poHeaderEntity.getId());
                    }
                    if(poHeaderEntity.getOrderType().equals(OrderEnum.PO_RETURN.getvalue())){
                        poLineEntity.setOrderQty(Math.abs(poLineEntity.getOrderQty())*-1);
                    }
                }
                this.save(poLineEntityList);
                poHeaderEntity.setOrderAmount(this.getOrderTotalPrice(poHeaderEntity.getId()));
                poHeaderService.updateById(poHeaderEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存订单行失败");
        }
    }

    @Override
    public void saveFreight(PoHeaderEntity poHeaderEntity) {
        try {
            List<PoLineEntity> poLineEntityList = poHeaderEntity.getLineList();
            if (poLineEntityList != null) {
                for (PoLineEntity poLineEntity : poLineEntityList) {
                    Integer acceptQty=Integer.parseInt(poLineEntity.get("acceptQty").toString());
                    float freight=0f;
                    if(poLineEntity.get("freight")!=null){
                        freight=Float.parseFloat(poLineEntity.get("freight").toString());
                    }
                    if(poHeaderEntity.getOrderType().equals(OrderEnum.PO.getvalue())){
                        poLineEntity.setTotalAcceptQty(poLineEntity.getTotalAcceptQty()+acceptQty);
                        poLineEntity.setTotalFreight(poLineEntity.getTotalFreight().add(new BigDecimal(freight)));
                    }
                    else if(poHeaderEntity.getOrderType().equals(OrderEnum.PO_RETURN.getvalue())){
                        poLineEntity.setTotalAcceptQty(poLineEntity.getTotalAcceptQty()+Math.abs(acceptQty)*-1);
                        poLineEntity.setTotalFreight(poLineEntity.getTotalFreight().add(new BigDecimal(Math.abs(freight)*-1)));
                    }
                }
                this.save(poLineEntityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存订单行失败");
        }
    }

    public BigDecimal getOrderTotalPrice(Integer poHeaderId){
        return baseMapper.getOrderTotalPrice(poHeaderId);
    }

    @Override
    public List<PoLineEntity> getPoLineEntityListByPoId(Integer poHeaderId) {
        return baseMapper.getPoLineEntityListByPoId(poHeaderId);
    }

    @Override
    public boolean isRkLast(Integer poHeaderId) {
        boolean result=true;
        Integer num=baseMapper.isRkLast(poHeaderId);
        if(num.intValue()>0){
            result=false;
        }
        return result;
    }

    @Override
    public void rollSourceLine(List<InoutBillLineEntity> inoutBillLineEntityList) {
        baseMapper.rollSourceLine(inoutBillLineEntityList);
    }

    @Override
    public BigDecimal getOrderTotalFreight(Integer poHeaderId) {
        return baseMapper.getOrderTotalFreight(poHeaderId);
    }
}