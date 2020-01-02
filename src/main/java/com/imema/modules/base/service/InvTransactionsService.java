package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.InvTransactions;

import java.util.Map;

public interface InvTransactionsService extends IService<InvTransactions> {
    PageUtils getList(Map<String, Object> params);
}
