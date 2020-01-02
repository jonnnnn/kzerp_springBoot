/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.data.DefaultBaseModel;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 出入库单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Mapper
public interface InoutBillLineDao extends BaseMapper<InoutBillLineEntity> {
    List<InoutBillLineEntity> getInoutBillLineEntityListByInoutBillId(Integer inoutBillId);

    Integer isExistAction(@Param("sourceId") Integer sourceId, @Param("sourceOrderType") String sourceOrderType);

    List<InoutBillLineEntity> getRollAction(@Param("sourceId") Integer sourceId, @Param("sourceOrderType") String sourceOrderType);

    Integer isActioned(Integer billId);

    void updateSourceLine(String tableName,Integer sourceId, String sourceOrderType);
    @Select("select bill_id as pick_id,sum(qty*cost_price)current_amount from inv_inout_bill_line where bill_id=#{billId}")
    DefaultBaseModel getCurrentData(Integer billId);
}
