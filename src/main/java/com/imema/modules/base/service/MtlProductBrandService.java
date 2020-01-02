package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MtlProduct;
import com.imema.modules.base.entity.MtlProductBrand;

import java.util.Map;

public interface MtlProductBrandService extends IService<MtlProductBrand> {
    PageUtils getList(Map<String, Object> params);
}
