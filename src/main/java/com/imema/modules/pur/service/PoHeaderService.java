/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.pur.entity.PoHeaderEntity;

import java.util.Map;

/**
 * 采购单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
public interface PoHeaderService extends IService<PoHeaderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

