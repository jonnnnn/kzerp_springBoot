package com.imema.modules.base.service.impl;

import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.SysBillnumRuleTypeDao;
import com.imema.modules.base.entity.SysBillnumRuleType;
import com.imema.modules.base.service.SysBillnumRuleTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.Lee
 * @since 2019-08-12 12:33
 * Description:
 **/
@Service("sysBillnumRuleTypeService")
public class SysBillnumRuleTypeServiceImpl extends
        BaseServiceImpl<SysBillnumRuleTypeDao, SysBillnumRuleType> implements SysBillnumRuleTypeService {
    @Override
    public List getCodeName(String name) {
        return baseMapper.queryCodeName(name);
    }
}
