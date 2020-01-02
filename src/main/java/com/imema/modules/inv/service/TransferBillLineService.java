/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.inv.entity.TransferBillEntity;
import com.imema.modules.inv.entity.TransferBillLineEntity;

import java.util.List;
import java.util.Map;

/**
 * 调拨单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
public interface TransferBillLineService extends IService<TransferBillLineEntity> {

    /**
     * 保存调拨明细
     * @param transferBillEntity
     */
    void save(TransferBillEntity transferBillEntity);
    /**
     * 根据调拨头ID获取调拨明细列表
     * @param transferBillId
     * @return
     */
    List<TransferBillLineEntity> getTransferBillLineEntityListByTransferBillId(Integer transferBillId);
}

