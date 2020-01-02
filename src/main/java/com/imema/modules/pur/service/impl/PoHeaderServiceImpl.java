/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.pur.dao.PoHeaderDao;
import com.imema.modules.pur.entity.PoHeaderEntity;
import com.imema.modules.pur.service.PoHeaderService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service("poHeaderService")
public class PoHeaderServiceImpl extends BaseServiceImpl<PoHeaderDao, PoHeaderEntity> implements PoHeaderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        IPage<PoHeaderEntity> page = baseMapper.queryPage(new Query<PoHeaderEntity>().getPage(pageForm),(LinkedHashMap)dataForm.get("data"));
        return new PageUtils(page);
    }

}