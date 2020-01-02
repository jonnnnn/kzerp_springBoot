/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.so.entity.SalesOrderEntity;
import com.imema.modules.so.entity.SalesOrderLineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 销售订单明细
 *
 * @author LG
 * @email imema@imema.com
 * @date 2019-07-25 16:48:58
 */
@Mapper
public interface SalesOrderLineDao extends BaseMapper<SalesOrderLineEntity> {

    List<SalesOrderLineEntity> getListByOrderId(Map<String ,Object> param);

    BigDecimal getTotalPrice(Integer orderId);

    /**
     * 首页销售统计
     */
    Map<String,Object> querySum(@Param("p") Map<String,Object> params);

}
