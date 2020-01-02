/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.so.entity.SalesOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 销售订单
 * 
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
@Mapper
public interface SalesOrderDao extends BaseMapper<SalesOrderEntity> {

//    List<SalesOrderEntity> orderList(Page<SalesOrderEntity> page, Map param);

    IPage<SalesOrderEntity> orderList(@Param("page") IPage<SalesOrderEntity> page,@Param("p") Map<String ,Object> param);

    List<Map<String,Object>> getProduct(Map<String ,Object> param);

    List<Map<String,Object>> getCustVender(Map<String ,Object> param);

    List<Map<String,Object>> getCustLastPrice(Map<String ,Object> param);


}
