package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MasCustVendor;

import java.util.List;
import java.util.Map;

public interface MasCustVendorService extends IService<MasCustVendor> {
    PageUtils getList(Map<String,Object> params);
}
