/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.data.DefaultBaseModel;
import com.imema.data.IBaseModel;
import com.imema.modules.inv.entity.OnhandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 现有量
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Mapper
public interface OnhandDao extends BaseMapper<OnhandEntity> {
    IPage<OnhandEntity> queryPage(IPage<OnhandEntity> page, @Param("p") Map<String, Object> params);

    Integer getSockByPW(Map<String, Object> params);

    DefaultBaseModel getCurrentValStock(@Param("iBaseModel")IBaseModel iBaseModel, @Param("iBaseModelLine")IBaseModel iBaseModelLine);
}
