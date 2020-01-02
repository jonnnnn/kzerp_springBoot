package com.imema.modules.base.service.impl;

/*
 * @author Mr.Lee
 * @time 2019/8/3  18:34
 * */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.SysBillnumRuleDao;
import com.imema.modules.base.entity.SysBillnumRule;
import com.imema.modules.base.service.SysBillnumRuleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysBillnumRuleService")
public class SysBillnumRuleServiceImpl extends BaseServiceImpl<SysBillnumRuleDao, SysBillnumRule>
        implements SysBillnumRuleService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<SysBillnumRule> page=baseMapper
                .selectByCodeName(new Query<SysBillnumRule>().getPage(pageForm),dataForm);

        return new PageUtils(page);
    }

    @Override
    public Integer queryExsistCount(Map<String, Object> param) {
        Integer companyId= ShiroUtils.getCompanyId();
        param.put("companyId",companyId);
        return baseMapper.selectCountByType(param);
    }

}
