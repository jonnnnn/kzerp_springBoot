package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MtlProductVehicle;

import java.util.Map;

public interface MtlProductVehicleService extends IService<MtlProductVehicle> {
    PageUtils getList(Map<String, Object> params);
}
