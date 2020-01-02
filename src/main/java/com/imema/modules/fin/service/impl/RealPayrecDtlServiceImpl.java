/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.service.impl;

import com.imema.core.BaseServiceImpl;
import com.imema.modules.fin.dao.RealPayrecDtlDao;
import com.imema.modules.fin.dao.RealPayrecOrdDao;
import com.imema.modules.fin.entity.RealPayrecDtlEntity;
import com.imema.modules.fin.entity.RealPayrecOrdEntity;
import com.imema.modules.fin.service.RealPayrecDtlService;
import com.imema.modules.fin.service.RealPayrecOrdService;
import org.springframework.stereotype.Service;


@Service("realPayrecDtlService")
public class RealPayrecDtlServiceImpl extends BaseServiceImpl<RealPayrecDtlDao, RealPayrecDtlEntity> implements RealPayrecDtlService {

}