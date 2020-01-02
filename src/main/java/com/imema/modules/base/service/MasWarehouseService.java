package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MasCustVendor;
import com.imema.modules.base.entity.MasWarehouse;

import java.util.Map;

public interface MasWarehouseService extends IService<MasWarehouse> {
    PageUtils getList(Map<String, Object> params);
}
