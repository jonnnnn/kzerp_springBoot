package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MtlProductPrice;
import com.imema.modules.form.FormParams;
import com.imema.modules.inv.entity.OnhandEntity;

import java.util.Map;

public interface MtlProductPriceService extends IService<MtlProductPrice> {
    PageUtils getList(Map<String,Object> params);

    /**
     * 新增或修改价格
     * @param onhandEntity
     */
    void addOrUpdate(OnhandEntity onhandEntity);

    /**
    * 检查productId是否已经存在
    */
    boolean checkProductId(Map<String,Object> params);

}
