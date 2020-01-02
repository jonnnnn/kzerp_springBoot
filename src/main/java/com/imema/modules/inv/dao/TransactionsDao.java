/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.TransactionsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 物料事务
 * 
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@Mapper
public interface TransactionsDao extends BaseMapper<TransactionsEntity> {
    /**
     * 获取库存流水表
     * @param page
     * @param params
     * @return
     */
    IPage<TransactionsEntity> queryPage(IPage<TransactionsEntity> page, @Param("p") Map<String, Object> params);
    /**
     * 批量插入事务处理
     * @param inoutBillEntity
     */
    void addTransactionsBatch(@Param("inoutBillEntity") InoutBillEntity inoutBillEntity);
	
}
