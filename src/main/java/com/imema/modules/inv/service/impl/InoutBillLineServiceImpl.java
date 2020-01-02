/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.data.DefaultBaseModel;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.dao.InoutBillLineDao;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.inv.service.InoutBillLineService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("inoutBillLineService")
public class InoutBillLineServiceImpl extends BaseServiceImpl<InoutBillLineDao, InoutBillLineEntity> implements InoutBillLineService {

    @Override
    public List<InoutBillLineEntity> getInoutBillLineEntityListByInoutBillId(Integer inoutBillId) {
        return baseMapper.getInoutBillLineEntityListByInoutBillId(inoutBillId);
    }

    @Override
    public void saveInoutBillLine(InoutBillEntity inoutBillEntity) throws RuntimeException {
        try {
            List<InoutBillLineEntity> inoutBillLineEntityList = inoutBillEntity.getLineList();
            List<InoutBillLineEntity> newInoutBillLineEntityList = new ArrayList<>();
            if (inoutBillLineEntityList != null && inoutBillLineEntityList.size()>0) {
                for (InoutBillLineEntity inoutBillLineEntity : inoutBillLineEntityList) {
                    if(inoutBillLineEntity.getStatus().equals(OrderEnum.NEW.getvalue())){
                        if(inoutBillLineEntity.getQty().intValue()!=inoutBillLineEntity.getRealQty().intValue()){
                            throw new RuntimeException("实际出入库数量不等于目标出入库数量");
                        }
                        inoutBillLineEntity.setStatus(OrderEnum.COMPLETED.getvalue());
                        inoutBillLineEntity.put("orderQty",inoutBillLineEntity.getRealQty());
                        newInoutBillLineEntityList.add(inoutBillLineEntity);
                    }
                }
                this.save(newInoutBillLineEntityList);
                inoutBillEntity.setLineList(newInoutBillLineEntityList);
            }else {
                throw new RuntimeException("明细不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存订单行失败！"+e.getMessage());
        }
    }

    @Override
    public boolean isExistAction( Integer sourceId, BasicEnum basicEnum) {
        boolean result=true;
        Integer actionNum=baseMapper.isExistAction(sourceId, basicEnum.getAttr());
        if(actionNum.intValue()>0){
            result=false;
        }
        return result;
    }

    @Override
    public List<InoutBillLineEntity> getRollAction(Integer sourceId, BasicEnum basicEnum) {
        return baseMapper.getRollAction(sourceId,basicEnum.getAttr());
    }

    @Override
    public boolean isActioned(Integer billId) {
        boolean result=true;
        Integer actionNum=baseMapper.isActioned(billId);
        if(actionNum.intValue()>0){
            result=false;
        }
        return result;
    }

    @Override
    public void updateSourceLine(Integer sourceId, BasicEnum basicEnum) throws RuntimeException {
        try {
            switch (basicEnum){
                case PO_IN:
                case PO_RETURN_OUT:{
                    baseMapper.updateSourceLine("pur_po_line",sourceId,basicEnum.getAttr());
                    break;
                }
                case SO_OUT:
                case SO_RETURN_IN:{
                    baseMapper.updateSourceLine("sal_sales_order_line",sourceId,basicEnum.getAttr());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改来源订单行失败"+e.getMessage());
        }
    }

    @Override
    public DefaultBaseModel getCurrentData(Integer billId) {
        return baseMapper.getCurrentData(billId);
    }
}