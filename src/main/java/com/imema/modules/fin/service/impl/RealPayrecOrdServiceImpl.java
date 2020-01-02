/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.fin.dao.RealPayrecDao;
import com.imema.modules.fin.dao.RealPayrecOrdDao;
import com.imema.modules.fin.entity.RealPayrecEntity;
import com.imema.modules.fin.entity.RealPayrecOrdEntity;
import com.imema.modules.fin.service.RealPayrecOrdService;
import com.imema.modules.fin.service.RealPayrecService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Service("realPayrecOrdService")
public class RealPayrecOrdServiceImpl extends BaseServiceImpl<RealPayrecOrdDao, RealPayrecOrdEntity> implements RealPayrecOrdService {

}