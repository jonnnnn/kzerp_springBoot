package com.imema.modules.base.web;

import cn.hutool.core.util.PinyinUtil;
import com.imema.common.utils.CommonUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProductVehicle;
import com.imema.modules.base.service.MtlProductVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/*
 * @author Mr.Lee
 * @time 2019/8/3  17:54
 * */
@RestController
@RequestMapping("/base/productvehicle")
public class MtlProductVehicleController {
    @Autowired
    private MtlProductVehicleService vehicleService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils result = vehicleService.getList(parameters);
        return R.ok().putData(result);
    }

    @PostMapping("/save")
    public R save(@RequestBody MtlProductVehicle vehicle) {
        String allFirstLetter = PinyinUtil.getAllFirstLetter(vehicle.getName());
        String wbCode = CommonUtils.getWBCode(vehicle.getName());

        vehicle.setPinyinCode(allFirstLetter);
        vehicle.setWbCode(wbCode);

        if (vehicle.getParentId()==null){
            vehicle.setParentId(0);
        }

        vehicleService.save(vehicle);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        vehicleService.removeByIds(ids);
        return R.ok();
    }
}
