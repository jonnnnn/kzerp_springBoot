package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MtlProductCategory;

import java.util.Map;

public interface MtlProductCategoryService extends IService<MtlProductCategory> {
    PageUtils getList(Map<String, Object> params);

    Integer checkCode(Map<String, Object> params);

    Map<String, Object> selectPcategoryId(String name);
}
