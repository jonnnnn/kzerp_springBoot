package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  0:54
 * */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.InvTransactionsDao;
import com.imema.modules.base.entity.InvTransactions;
import com.imema.modules.base.service.InvTransactionsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("invTransactionsService")
public class InvTransactionsServiceImpl extends BaseServiceImpl<InvTransactionsDao, InvTransactions> implements InvTransactionsService {
    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");

        String name = (String)dataForm.get("name");

        IPage<InvTransactions> page = this.page(
                new Query<InvTransactions>().getPage(pageForm),
                new QueryWrapper<InvTransactions>()
                        .like(StringUtils.isNotBlank(name),"name", name)
        );
        return new PageUtils(page);
    }
}
