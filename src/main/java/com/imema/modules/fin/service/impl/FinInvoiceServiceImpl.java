package com.imema.modules.fin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.fin.dao.FinInvoiceDao;
import com.imema.modules.fin.entity.FinInvoice;
import com.imema.modules.fin.service.FinInvoiceService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author Mr.Lee
 * @since 2019-08-27 11:13
 * Description:
 **/
@Service("finInvoiceService")
public class FinInvoiceServiceImpl extends BaseServiceImpl<FinInvoiceDao, FinInvoice> implements FinInvoiceService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<FinInvoice> page = baseMapper.queryList(
                new Query<FinInvoice>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }

    @Override
    public Integer checkCode(Map<String, Object> params) {
        params.put("companyId", ShiroUtils.getCompanyId());
        return baseMapper.selectCountByCode(params);
    }
}
