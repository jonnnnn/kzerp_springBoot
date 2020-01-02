package com.imema.modules.fin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.fin.entity.FinInvoice;

import java.text.ParseException;
import java.util.Map;

public interface FinInvoiceService  extends IService<FinInvoice> {
    PageUtils getList(Map<String,Object> params) throws ParseException;

    Integer checkCode(Map<String, Object> params);
}
