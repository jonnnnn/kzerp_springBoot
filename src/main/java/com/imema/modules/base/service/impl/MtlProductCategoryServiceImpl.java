package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  1:03
 * */

import com.imema.common.utils.*;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MtlProductCategoryDao;
import com.imema.modules.base.entity.MtlProductCategory;
import com.imema.modules.base.service.MtlProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mtlProductCategoryService")
public class MtlProductCategoryServiceImpl extends BaseServiceImpl<MtlProductCategoryDao, MtlProductCategory> implements MtlProductCategoryService {
    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> dataForm = R.extractParams(params);
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");

        List<MtlProductCategory> data = baseMapper.queryPage(dataForm);

        TreeDataUtils<MtlProductCategory> dataUtils=new TreeDataUtils<>(data);
        return dataUtils.handlePage(pageForm);
    }

    @Override
    public Integer checkCode(Map<String, Object> params) {
        params.put("companyId",ShiroUtils.getCompanyId());
        return baseMapper.checkCode(params);
    }

    @Override
    public Map<String, Object> selectPcategoryId(String name) {
        return baseMapper.selectPcategory(name);
    }
}
