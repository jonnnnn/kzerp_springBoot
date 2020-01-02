/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.data.DefaultBaseModel;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.InoutBillLineEntity;

import java.util.List;
import java.util.Map;

/**
 * 出入库单明细
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
public interface InoutBillLineService extends IService<InoutBillLineEntity> {
    /**
     * 根据出入库头ID获取出入库明细列表
     * @param inoutBillId
     * @return
     */
    List<InoutBillLineEntity> getInoutBillLineEntityListByInoutBillId(Integer inoutBillId);
    /**
     * 保存拣货明细
     * @param inoutBillEntity
     */
    void saveInoutBillLine(InoutBillEntity inoutBillEntity) throws RuntimeException;

    /**
     * 根据来源判断是否已经拣货
     * @param sourceId 来源ID
     * @param basicEnum 来源事物类型
     * @return
     */
    boolean isExistAction(Integer sourceId, BasicEnum basicEnum);
    /**
     * 根据来源获取需要回滚的拣货
     * @param sourceId 来源ID
     * @param basicEnum 来源事物类型
     * @return
     */
    List<InoutBillLineEntity> getRollAction(Integer sourceId, BasicEnum basicEnum);

    /**
     * 是否拣货完成
     * @param billId
     * @return
     */
    boolean isActioned(Integer billId);

    /**
     * 根据拣货修改来源订单行信息
     * @param sourceId
     * @param basicEnum
     */
    void updateSourceLine(Integer sourceId, BasicEnum basicEnum) throws RuntimeException;

    /**
     * 根据拣货ID获取当前拣货的金额
     * @param billId
     * @return
     */
    DefaultBaseModel getCurrentData(Integer billId);
}

