/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.TransactionsEntity;

import java.util.Map;

/**
 * 物料事务
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
public interface TransactionsService extends IService<TransactionsEntity> {
    /**
     * 获取库存流水表
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 添加库存流水表
     * @param inoutBillEntity
     * @throws RuntimeException
     */
    void add(InoutBillEntity inoutBillEntity)throws RuntimeException;
}

