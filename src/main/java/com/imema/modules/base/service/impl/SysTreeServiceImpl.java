package com.imema.modules.base.service.impl;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.common.utils.TreeDataUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.SysTreeDao;
import com.imema.modules.base.entity.SysTree;
import com.imema.modules.base.service.SysTreeService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Mr.Lee
 * @since 2019-07-31 18:08
 * Description:
 **/
@Service("sysTreeService")
public class SysTreeServiceImpl extends BaseServiceImpl<SysTreeDao, SysTree> implements SysTreeService {
    @Override
    public PageUtils queryList(Map<String, Object> params) {
        Map<String, Object> dataForm = R.extractParams(params);
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");

        List<SysTree> data = baseMapper.selectTreeByMapOps(dataForm);

        return new TreeDataUtils<>(data).handlePage(pageForm);
    }

    public List<SysTree> getList(Map<String, Object> params) {
        Map<String, Object> dataForm = R.extractParams(params);

        List<SysTree> data = baseMapper.selectTreeByMapOps(dataForm);
        TreeDataUtils<SysTree> treeDataUtils = new TreeDataUtils<>(data);
        return treeDataUtils.getTreeData();
    }

    @Override
    public Integer checkCode(Map<String, Object> params) {
        Integer companyId = ShiroUtils.getCompanyId();
        params.put("companyId", companyId);
        return baseMapper.selectByCode(params);
    }
}
