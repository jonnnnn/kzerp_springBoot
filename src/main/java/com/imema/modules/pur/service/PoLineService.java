/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.pur.entity.PoHeaderEntity;
import com.imema.modules.pur.entity.PoLineEntity;

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
public interface PoLineService extends IService<PoLineEntity> {
    /**
     * 保存采购明细
     * @param poHeaderEntity
     */
    void save(PoHeaderEntity poHeaderEntity);
    /**
     * 分摊采购明细运费
     * @param poHeaderEntity
     */
    void saveFreight(PoHeaderEntity poHeaderEntity);

    /**
     * 根据采购头ID获取采购明细列表
     * @param poHeaderId
     * @return
     */
    List<PoLineEntity> getPoLineEntityListByPoId(Integer poHeaderId);

    /**
     * 判断是否入库完成
     * @param poHeaderId
     * @return
     */
    boolean isRkLast(Integer poHeaderId);

    /**
     * 回滚采购明细数量跟运费
     * @param inoutBillLineEntityList
     */
    void rollSourceLine(List<InoutBillLineEntity> inoutBillLineEntityList);

    /**
     * 根据采购订单ID获取明细的累计运费
     * @param poHeaderId
     * @return
     */
    BigDecimal getOrderTotalFreight(Integer poHeaderId);

}

