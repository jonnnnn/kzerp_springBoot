/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.inv.entity.CheckBillEntity;
import com.imema.modules.inv.entity.CheckBillLineEntity;

import java.util.List;
import java.util.Map;

/**
 * 盘点单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
public interface CheckBillLineService extends IService<CheckBillLineEntity> {

    /**
     * 保存盘点明细
     * @param checkBillEntity
     */
    void save(CheckBillEntity checkBillEntity);

    /**
     * 根据盘点头ID获取盘点明细列表
     * @param checkBillId
     * @return
     */
    List<CheckBillLineEntity> getCheckBillLineEntityListByCheckBillId(Integer checkBillId);
}

