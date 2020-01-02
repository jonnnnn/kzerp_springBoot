package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  0:43
 * */


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.IntegerUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.InvReservationsDao;
import com.imema.modules.base.entity.InvReservations;
import com.imema.modules.base.service.InvReservationsService;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service("invReservationsService")
public class InvReservationsServiceImpl extends BaseServiceImpl<InvReservationsDao, InvReservations> implements InvReservationsService {
    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        QueryWrapper<InvReservations> wrapper;
        Integer productId = IntegerUtils.parseInt((String)dataForm.get("productId"));
        Integer warehouseId=IntegerUtils.parseInt((String)dataForm.get("warehouseId"));

        wrapper=new QueryWrapper<InvReservations>()
                    .like(productId!=null,"product_id", productId)
                    .like(warehouseId!=null,"warehouse_id", warehouseId);
        IPage<InvReservations> page = this.page(
                new Query<InvReservations>().getPage(pageForm), wrapper
        );
        return new PageUtils(page);
    }
}
