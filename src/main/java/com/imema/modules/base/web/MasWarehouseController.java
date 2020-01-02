package com.imema.modules.base.web;

/*
 * @author Mr.Lee
 * @time 2019/8/3  17:51
 * */

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MasWarehouse;
import com.imema.modules.base.service.MasWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/base/warehouse")
public class MasWarehouseController {
    @Autowired
    private MasWarehouseService masWarehouseService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = masWarehouseService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MasWarehouse masWarehouse) {
        masWarehouseService.save(masWarehouse);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        masWarehouseService.removeByIds(ids);
        return R.ok();
    }
}
