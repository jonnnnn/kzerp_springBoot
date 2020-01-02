package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  1:01
 * */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.IntegerUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MasWarehouseSlotDao;
import com.imema.modules.base.entity.MasWarehouseSlot;
import com.imema.modules.base.service.MasWarehouseSlotService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("masWarehouseSlotService")
public class MasWarehouseSlotServiceImpl extends BaseServiceImpl<MasWarehouseSlotDao, MasWarehouseSlot> implements MasWarehouseSlotService {

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        IPage<MasWarehouseSlot> page = baseMapper.queryByMap(
                new Query<MasWarehouseSlot>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }
}
