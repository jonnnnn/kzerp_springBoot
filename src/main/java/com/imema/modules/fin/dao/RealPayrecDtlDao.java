/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.fin.entity.RealPayrecDtlEntity;
import com.imema.modules.fin.entity.RealPayrecOrdEntity;
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
public interface RealPayrecDtlDao extends BaseMapper<RealPayrecDtlEntity> {

    IPage<RealPayrecDtlEntity> queryPage(IPage<RealPayrecDtlEntity> page, @Param("p") Map<String, Object> params);

}
