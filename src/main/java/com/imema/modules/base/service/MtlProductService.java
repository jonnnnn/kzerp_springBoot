package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MasWarehouseSlot;
import com.imema.modules.base.entity.MtlProduct;

import java.util.List;
import java.util.Map;

public interface MtlProductService extends IService<MtlProduct> {
    PageUtils getList(Map<String, Object> params);

    List<MtlProduct> searchProduct(Map<String,Object> map);

    String searchProductIds(String map);

    Integer checkCode(Map<String,Object> params);
}
