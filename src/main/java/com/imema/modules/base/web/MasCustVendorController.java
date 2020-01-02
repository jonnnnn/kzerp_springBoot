package com.imema.modules.base.web;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.modules.base.entity.MasCustVendor;
import com.imema.modules.base.service.MasCustVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/base/cust")
public class MasCustVendorController {
    @Autowired
    private MasCustVendorService custVendorService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page =custVendorService.getList(parameters);
        return R.ok().putData(page);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@RequestBody MasCustVendor vendor){
        Integer id=vendor.getId();
        if (id==null||id==0){
            vendor.setPic(ShiroUtils.getUserEntity().getUsername());
        }
        custVendorService.save(vendor);
        return R.ok();
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        custVendorService.removeByIds(ids);
        return R.ok();
    }
}
