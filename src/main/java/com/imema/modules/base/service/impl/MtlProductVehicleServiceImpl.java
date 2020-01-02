package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  1:05
 * */


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.*;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MtlProductVehicleDao;
import com.imema.modules.base.entity.MtlProductCategory;
import com.imema.modules.base.entity.MtlProductVehicle;
import com.imema.modules.base.entity.SysTree;
import com.imema.modules.base.service.MtlProductVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mtlProductVehicleService")
public class MtlProductVehicleServiceImpl extends BaseServiceImpl<MtlProductVehicleDao, MtlProductVehicle> implements MtlProductVehicleService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> dataForm = R.extractParams(params);
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");

        List<MtlProductVehicle> data = baseMapper.queryPage(dataForm);
        TreeDataUtils<MtlProductVehicle> dataUtils=new TreeDataUtils<>(data);
        return dataUtils.handlePage(pageForm);
    }
}
