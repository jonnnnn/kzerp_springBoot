/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.fin.entity.PayrecEntity;

import java.util.Map;

/**
 * 应收应付单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:38
 */
public interface PayrecService extends IService<PayrecEntity> {

    PageUtils queryPage(Map<String, Object> params);

    R createrPayrec(Object obj, OrderEnum orderEnum);

    R cancelPayrec(Object obj, OrderEnum orderEnum);
}

