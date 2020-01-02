/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.fin.entity.RealPayrecEntity;

import java.util.Map;

/**
 * 收付款单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:37
 */
public interface RealPayrecService extends IService<RealPayrecEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R savePay(RealPayrecEntity realPayrecEntity);
}

