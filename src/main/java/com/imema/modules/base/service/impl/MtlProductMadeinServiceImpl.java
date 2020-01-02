package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  1:04
 * */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.CommonStringUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MtlProductMadeinDao;
import com.imema.modules.base.entity.MtlProductMadein;
import com.imema.modules.base.service.MtlProductMadeinService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@Service("mtlProductMadeinService")
public class MtlProductMadeinServiceImpl extends BaseServiceImpl<MtlProductMadeinDao, MtlProductMadein> implements MtlProductMadeinService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<MtlProductMadein> page = baseMapper.queryPage(
                new Query<MtlProductMadein>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }
}
