package com.imema.modules.fin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.fin.entity.FinAccount;

import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-27 11:12
 * Description:
 **/
public interface FinAccountService  extends IService<FinAccount> {
    PageUtils getList(Map<String,Object> params);
    Integer selectCountByName(String name);
}
