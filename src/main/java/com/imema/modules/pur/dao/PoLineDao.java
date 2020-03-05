/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.pur.entity.PoLineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 进货单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
@Mapper
public interface PoLineDao extends BaseMapper<PoLineEntity> {
    @Select("select sum(order_qty*cost_price) from pur_po_line where order_id=#{poHeaderId}")
    BigDecimal getOrderTotalPrice(Integer poHeaderId);

    List<Map<String,Object>> getPoLineEntityListByPoId(Integer poHeaderId);

    @Select("select count(*) from pur_po_line where abs(ifnull(order_qty,0)-ifnull(total_accept_qty,0))>0 and order_id=#{poHeaderId}")
    Integer isRkLast(Integer poHeaderId);
    void rollSourceLine(@Param("inoutBillLineEntityList") List<InoutBillLineEntity> inoutBillLineEntityList);

    @Select("select sum(ifnull(total_freight,0)) from pur_po_line where order_id=#{poHeaderId}")
    BigDecimal getOrderTotalFreight(Integer poHeaderId);

    List<Map<String,Object>> getList(@Param("pa")Map<String,Object> params);
}
