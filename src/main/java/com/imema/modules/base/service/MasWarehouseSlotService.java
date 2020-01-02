package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MasWarehouse;
import com.imema.modules.base.entity.MasWarehouseSlot;

import java.util.Map;

public interface MasWarehouseSlotService extends IService<MasWarehouseSlot> {
    PageUtils getList(Map<String, Object> params);
}
