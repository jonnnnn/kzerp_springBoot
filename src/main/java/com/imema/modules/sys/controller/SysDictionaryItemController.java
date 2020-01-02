package com.imema.modules.sys.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.sys.entity.SysDictionaryItemEntity;
import com.imema.modules.sys.service.SysDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-09-02 15:32
 * Description: 系统字典
 **/
@RestController
@RequestMapping("/sys/dict")
public class SysDictionaryItemController {
    @Autowired
    private SysDictionaryItemService itemService;

    @PostMapping("/list")
    public R queryPage(@RequestBody Map<String,Object> params){
        PageUtils page=itemService.queryPage(params);
        return R.ok().putData(page);
    }

    @PostMapping("/checkCode")
    public R checkCode(@RequestBody Map<String,Object> params){
        int result=itemService.checkCode(params);
        return result>0?R.ok().putData("编码不能重复！"):R.ok();
    }

    @PostMapping("/save")
    public R save(@RequestBody SysDictionaryItemEntity itemEntity){
        itemService.save(itemEntity);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String, Object> params) {
        List<Integer> ids = (List<Integer>) params.get("ids");
        itemService.removeByIds(ids);
        return R.ok();
    }
}
