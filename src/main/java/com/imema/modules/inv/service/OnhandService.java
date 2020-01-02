/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.dto.OnhandDto;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.OnhandEntity;

import java.util.Map;

/**
 * 现有量
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
public interface OnhandService extends IService<OnhandEntity> {

    PageUtils queryPage(Map<String, Object> params);
    void addOrUpdate(InoutBillEntity inoutBillEntity)throws RuntimeException;
    void valOnhand(final Object objectClass) throws RuntimeException;
}

