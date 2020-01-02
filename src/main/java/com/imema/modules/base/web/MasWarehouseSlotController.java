package com.imema.modules.base.web;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MasWarehouseSlot;
import com.imema.modules.base.service.MasWarehouseSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 * @author Mr.Lee
 * @time 2019/8/3  17:51
 * */
@RestController
@RequestMapping("/base/warehouseslot")
public class MasWarehouseSlotController {
    @Autowired
    private MasWarehouseSlotService slotService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = slotService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MasWarehouseSlot slot) {
        slotService.save(slot);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        slotService.removeByIds(ids);
        return R.ok();
    }
}
