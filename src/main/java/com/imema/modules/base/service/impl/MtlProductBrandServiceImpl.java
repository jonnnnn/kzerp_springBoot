package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  1:02
 * */
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MtlProductBrandDao;
import com.imema.modules.base.entity.MtlProductBrand;
import com.imema.modules.base.service.MtlProductBrandService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("mtlProductBrandService")
public class MtlProductBrandServiceImpl extends BaseServiceImpl<MtlProductBrandDao,MtlProductBrand> implements MtlProductBrandService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<MtlProductBrand> page = baseMapper.queryPage(
                new Query<MtlProductBrand>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }
}
