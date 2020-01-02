package com.imema.modules.fin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.fin.dao.FinAccountDao;
import com.imema.modules.fin.entity.FinAccount;
import com.imema.modules.fin.service.FinAccountService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-27 11:13
 * Description:
 **/
@Service("finAccountService")
public class FinAccountServiceImpl extends BaseServiceImpl<FinAccountDao,FinAccount> implements FinAccountService {
    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<FinAccount> page = baseMapper.queryList(
                new Query<FinAccount>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }

    @Override
    public Integer selectCountByName(String name) {
        return baseMapper.selectCountByName(name);
    }
}
