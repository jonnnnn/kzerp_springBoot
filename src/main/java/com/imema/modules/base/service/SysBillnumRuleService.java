package com.imema.modules.base.service;

/*
 * @author Mr.Lee
 * @time 2019/8/3  18:33
 * */

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.SysBillnumRule;

import java.util.Map;

public interface SysBillnumRuleService extends IService<SysBillnumRule> {
    PageUtils getList(Map<String,Object> params);

    Integer queryExsistCount(Map<String,Object> param);
}
