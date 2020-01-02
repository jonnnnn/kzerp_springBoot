/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.data.DefaultBaseModel;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.inv.entity.CheckBillEntity;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.inv.entity.TransferBillEntity;
import com.imema.modules.pur.entity.PoHeaderEntity;

import java.util.List;
import java.util.Map;

/**
 * 出入库单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:40
 */
public interface InoutBillService extends IService<InoutBillEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 自动出入库
     * @param objectClass   如果需要自动完成出入库，必须传入扩展字段isAuto=true,仓库ID：warehouseId
     * @param basicEnum
     * @throws RuntimeException
     */
    DefaultBaseModel autoCreate(Object objectClass, BasicEnum basicEnum) throws RuntimeException;

    /**
     * 调拨出入库，如果需要自动完成出入库，必须传入扩展字段isAuto=true,仓库ID：fromWarehouseId,toWarehouseId
     * @param transferBillEntity
     * @param basicEnum
     * @throws RuntimeException
     */
    void createActionByTransferBill(TransferBillEntity transferBillEntity, BasicEnum basicEnum)throws RuntimeException;
    /**
     * 保存出入库
     * @param inoutBillEntity
     */
    void saveInoutBill(InoutBillEntity inoutBillEntity) throws RuntimeException;

    /**
     * 回滚出入库单
     * @param sourceId 来源单据ID
     * @param basicEnum 事物类型
     * @throws RuntimeException
     */
    void rollbackInoutBill(Integer sourceId,BasicEnum basicEnum) throws RuntimeException;
    /**
     * 采购/采购退货回滚出入库单
     * @param sourceId 来源单据ID
     * @param basicEnum 事物类型
     * @throws RuntimeException
     */
    List<InoutBillLineEntity> rollbackInoutBillByPoAndPoReturn(Integer sourceId, BasicEnum basicEnum) throws RuntimeException;

}

