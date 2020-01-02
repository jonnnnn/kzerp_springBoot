package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.InvReservations;

import java.util.Map;

public interface InvReservationsService extends IService<InvReservations> {
    PageUtils getList(Map<String, Object> params);
}
