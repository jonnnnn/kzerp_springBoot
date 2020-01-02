/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.inv.entity.CheckBillEntity;

import java.util.Map;

/**
 * 盘点单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
public interface CheckBillService extends IService<CheckBillEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void submit(CheckBillEntity checkBillEntity);
}

