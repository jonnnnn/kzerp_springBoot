/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.inv.entity.CheckBillEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 盘点单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@Mapper
public interface CheckBillDao extends BaseMapper<CheckBillEntity> {
    IPage<CheckBillEntity> queryPage(IPage<CheckBillEntity> page, @Param("p") Map<String, Object> params);
}
