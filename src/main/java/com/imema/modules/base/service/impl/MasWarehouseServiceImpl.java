package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  0:57
 * */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MasWarehouseDao;
import com.imema.modules.base.entity.MasWarehouse;
import com.imema.modules.base.service.MasWarehouseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("masWarehouseService")
public class MasWarehouseServiceImpl extends BaseServiceImpl<MasWarehouseDao, MasWarehouse> implements MasWarehouseService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<MasWarehouse> page = baseMapper.queryPage(
                new Query<MasWarehouse>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }
}
