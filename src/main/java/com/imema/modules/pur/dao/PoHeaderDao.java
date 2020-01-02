/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.pur.entity.PoHeaderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 采购单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
@Mapper
public interface PoHeaderDao extends BaseMapper<PoHeaderEntity> {
    IPage<PoHeaderEntity> queryPage(IPage<PoHeaderEntity> page, @Param("p") Map<String, Object> params);
}
