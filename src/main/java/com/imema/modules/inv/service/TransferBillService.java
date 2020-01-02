/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.inv.entity.TransferBillEntity;

import java.util.Map;

/**
 * 调拨单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
public interface TransferBillService extends IService<TransferBillEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

