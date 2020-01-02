/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 出入库单
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@Mapper
public interface InoutBillDao extends BaseMapper<InoutBillEntity> {
    IPage<InoutBillEntity> queryPage(IPage<InoutBillEntity> page, @Param("p") Map<String, Object> params);

    void rollbackInoutBill(Integer sourceId, String sourceOrderType);

    void rollbackInoutBillByPoAndPoReturn(@Param("inoutBillLineEntityList") List<InoutBillLineEntity> inoutBillLineEntityList);

    Integer isActioned(Integer sourceId, String sourceOrderType);
}
