package com.imema.modules.base.web;

/*
 * @author Mr.Lee
 * @time 2019/8/3  17:49
 * */

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MasCustVendorContact;
import com.imema.modules.base.service.MasCustVendorContactService;
import com.imema.modules.form.FormParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/base/custcontact")
public class MasCustVendorContactController {
    @Autowired
    private MasCustVendorContactService contactService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = contactService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/pageList")
    public R pageList(@RequestBody FormParams parameters) {
        PageUtils page = contactService.getPageList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MasCustVendorContact contact) {
        contactService.save(contact);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        contactService.removeByIds(ids);
        return R.ok();
    }
}
