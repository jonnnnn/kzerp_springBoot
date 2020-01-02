/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.enums.EntityState;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.inv.dao.CheckBillLineDao;
import com.imema.modules.inv.entity.CheckBillEntity;
import com.imema.modules.inv.entity.CheckBillLineEntity;
import com.imema.modules.inv.service.CheckBillLineService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("checkBillLineService")
public class CheckBillLineServiceImpl extends BaseServiceImpl<CheckBillLineDao, CheckBillLineEntity> implements CheckBillLineService {

    @Override
    public void save(CheckBillEntity checkBillEntity) throws RuntimeException{
        try {
            List<CheckBillLineEntity> checkBillEntityLineList = checkBillEntity.getLineList();
            if (checkBillEntityLineList != null) {
                for (CheckBillLineEntity poLineEntity : checkBillEntityLineList) {
                    if (poLineEntity.getState().equals(EntityState.NEW)) {
                        poLineEntity.setCheckBillId(checkBillEntity.getId());
                    }
                }
                this.save(checkBillEntityLineList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存订单行失败");
        }
    }


    @Override
    public List<CheckBillLineEntity> getCheckBillLineEntityListByCheckBillId(Integer checkBillId) {
        return baseMapper.getCheckBillLineEntityListByCheckBillId(checkBillId);
    }

}