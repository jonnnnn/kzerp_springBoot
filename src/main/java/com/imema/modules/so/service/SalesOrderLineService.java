/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.so.entity.SalesOrderLineEntity;

import java.util.List;
import java.util.Map;

/**
 * 销售订单明细
 *
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
public interface SalesOrderLineService extends IService<SalesOrderLineEntity> {

    List<Map> queryOrder(Map<String, Object> params);

    Map<String,Object> querySummary(Map<String,Object> params);
}

