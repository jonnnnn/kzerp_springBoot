package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.MasCustVendorContact;
import com.imema.modules.form.FormParams;

import java.util.Map;

public interface MasCustVendorContactService extends IService<MasCustVendorContact> {
    PageUtils getList(Map<String, Object> params);

    PageUtils getPageList(FormParams formParams);
}
