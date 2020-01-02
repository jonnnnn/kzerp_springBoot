/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.inv.dao.TransferBillDao;
import com.imema.modules.inv.entity.TransferBillEntity;
import com.imema.modules.inv.service.TransferBillService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service("transferBillService")
public class TransferBillServiceImpl extends BaseServiceImpl<TransferBillDao, TransferBillEntity> implements TransferBillService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        IPage<TransferBillEntity> page = baseMapper.queryPage(new Query<TransferBillEntity>().getPage(pageForm),(LinkedHashMap)dataForm.get("data"));
        return new PageUtils(page);
    }

}