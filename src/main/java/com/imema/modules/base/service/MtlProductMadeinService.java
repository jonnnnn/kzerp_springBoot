package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MtlProductCategory;
import com.imema.modules.base.entity.MtlProductMadein;

import java.util.Map;

public interface MtlProductMadeinService extends IService<MtlProductMadein> {
    PageUtils getList(Map<String, Object> params);
}
