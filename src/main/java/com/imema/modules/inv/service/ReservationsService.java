/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.dto.OnhandDto;
import com.imema.modules.inv.entity.ReservationsEntity;

import java.util.Map;

/**
 * 物料保留
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
public interface ReservationsService extends IService<ReservationsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void add(Object objectClass)throws RuntimeException;
    void del(Object objectClass)throws RuntimeException;
}

