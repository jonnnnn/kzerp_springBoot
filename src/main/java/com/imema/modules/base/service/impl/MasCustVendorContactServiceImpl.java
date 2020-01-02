package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  0:56
 * */
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MasCustVendorContactDao;
import com.imema.modules.base.entity.MasCustVendorContact;
import com.imema.modules.base.service.MasCustVendorContactService;
import com.imema.modules.form.FormParams;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("masCustVendorContactService")
public class MasCustVendorContactServiceImpl extends BaseServiceImpl<MasCustVendorContactDao, MasCustVendorContact>
        implements MasCustVendorContactService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<MasCustVendorContact> page = baseMapper.selectByMap(
                new Query<MasCustVendorContact>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }

    @Override
    public PageUtils getPageList(FormParams formParams) {
        Map<String, Object> pageForm = formParams.getPageForm();
        Map<String, Object> dataForm = formParams.getData();

        IPage<MasCustVendorContact> page = baseMapper.selectByMap(
                new Query<MasCustVendorContact>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }
}
