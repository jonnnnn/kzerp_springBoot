/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProduct;
import com.imema.modules.so.entity.SalesOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 销售订单
 *
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
public interface SalesOrderService extends IService<SalesOrderEntity> {

    PageUtils queryOrder(Map<String, Object> params);

    List<Map<String, Object>> getProduct(Map<String, Object> params);

    R saveOrder(SalesOrderEntity orderEntity);


    List<Map<String, Object>> getCustVender(Map<String, Object> params);

    void setCustLastPrice(Integer custId, List<MtlProduct> products);

    R submit(String id);

}

