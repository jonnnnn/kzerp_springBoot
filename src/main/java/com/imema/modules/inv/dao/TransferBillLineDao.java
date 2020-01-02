/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.inv.entity.TransferBillLineEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 调拨单明细
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Mapper
public interface TransferBillLineDao extends BaseMapper<TransferBillLineEntity> {
    List<TransferBillLineEntity> getTransferBillLineEntityListByTransferBillId(Integer transferBillId);
}
