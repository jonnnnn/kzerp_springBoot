package com.imema.modules.base.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MasCustVendorDao;
import com.imema.modules.base.entity.MasCustVendor;
import com.imema.modules.base.service.MasCustVendorService;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("masCustVendorService")
public class MasCustVendorServiceImpl extends BaseServiceImpl<MasCustVendorDao, MasCustVendor>
        implements MasCustVendorService {
    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<MasCustVendor> page = baseMapper.queryPage(
                new Query<MasCustVendor>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }
}
