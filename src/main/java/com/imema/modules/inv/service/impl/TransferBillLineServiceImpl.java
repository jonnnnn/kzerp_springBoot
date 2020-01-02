/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.enums.EntityState;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.inv.dao.TransferBillLineDao;
import com.imema.modules.inv.entity.TransferBillEntity;
import com.imema.modules.inv.entity.TransferBillLineEntity;
import com.imema.modules.inv.service.TransferBillLineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("transferBillLineService")
public class TransferBillLineServiceImpl extends BaseServiceImpl<TransferBillLineDao, TransferBillLineEntity> implements TransferBillLineService {


    @Override
    public void save(TransferBillEntity transferBillEntity) {
        try {
            List<TransferBillLineEntity> transferBillLineEntityList = transferBillEntity.getLineList();
            if (transferBillLineEntityList != null) {
                for (TransferBillLineEntity transferBillLineEntity : transferBillLineEntityList) {
                    if (transferBillLineEntity.getState().equals(EntityState.NEW)) {
                        transferBillLineEntity.setTransferBillId(transferBillEntity.getId());
                    }
                }
                this.save(transferBillLineEntityList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("保存订单行失败");
        }
    }

    @Override
    public List<TransferBillLineEntity> getTransferBillLineEntityListByTransferBillId(Integer transferBillId) {
        return baseMapper.getTransferBillLineEntityListByTransferBillId(transferBillId);
    }
}