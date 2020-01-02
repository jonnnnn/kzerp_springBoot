package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.modules.base.entity.SysBillnumRuleType;

import java.util.List;
import java.util.Map;

public interface SysBillnumRuleTypeService extends IService<SysBillnumRuleType> {

    List getCodeName(String name);
}
