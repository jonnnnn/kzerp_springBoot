/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.dao;

import com.imema.modules.fin.entity.RealPayrecEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


/**
 * 收付款单
 *
 * @author kinble
 * @email kinble@imema.com.cn
 * @date 2019-08-27 17:00:37
 */
@Mapper
public interface RealPayrecDao extends BaseMapper<RealPayrecEntity> {

    IPage<RealPayrecEntity> queryPage(@Param("page") IPage<RealPayrecEntity> page, @Param("p") Map<String, Object> params);

}
