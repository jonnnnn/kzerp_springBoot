/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.inv.entity.CheckBillLineEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 盘点单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
@Mapper
public interface CheckBillLineDao extends BaseMapper<CheckBillLineEntity> {
    List<CheckBillLineEntity> getCheckBillLineEntityListByCheckBillId(Integer checkBillId);
}
