package com.imema.modules.base.web;

/*
 * @author Mr.Lee
 * @time 2019/8/2  1:25
 * */

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.InvReservations;
import com.imema.modules.base.service.InvReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/base/reservation")
public class InvReservationsController {
    @Autowired
    private InvReservationsService reservationsService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page=reservationsService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody InvReservations reservations){
        reservationsService.save(reservations);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        reservationsService.removeByIds(ids);
        return R.ok();
    }
}
