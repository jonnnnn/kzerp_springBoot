package com.imema.modules.fin.service.impl;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.utils.TreeDataUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.entity.SysTree;
import com.imema.modules.fin.dao.FinSubjectDao;
import com.imema.modules.fin.entity.FinSubject;
import com.imema.modules.fin.service.FinSubjectService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Mr.Lee
 * @since 2019-08-29 17:08
 * Description:
 **/
@Service("finSubjectService")
public class FinSubjectServiceImpl extends BaseServiceImpl<FinSubjectDao, FinSubject>
        implements FinSubjectService {
    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);


        List<FinSubject> data = baseMapper.queryList(dataForm);

        TreeDataUtils<FinSubject> dataUtils = new TreeDataUtils<>(data);
        return dataUtils.handlePage(pageForm);
    }
}
