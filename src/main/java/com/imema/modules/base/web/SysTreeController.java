package com.imema.modules.base.web;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.SysTree;
import com.imema.modules.base.service.SysTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-07-31 17:31
 * Description: 主从结构通用表Controller
 **/
//TODO API文档
@RestController
@RequestMapping("/base/tree")
public class SysTreeController {
    @Autowired
    private SysTreeService treeService;

    @PostMapping("/list")
    public R treeList(@RequestBody Map<String,Object> parameters){
        PageUtils list =treeService.queryList(parameters);
        return R.ok().putData(list);
    }

//    无分页
    @PostMapping("/nolist")
    public R simpleList(@RequestBody Map<String,Object> parameters){
        List<SysTree> list =treeService.getList(parameters);
        return R.ok().putData(list);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public R save(@RequestBody SysTree tree){
        treeService.save(tree);
        return R.ok();
    }

    @RequestMapping(value = "/checkCode",method = RequestMethod.POST)
    public R checkCode(@RequestBody Map<String,Object> params){
        Integer count = treeService.checkCode(params);
        return R.ok().putData(count);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        treeService.removeByIds(ids);
        return R.ok();
    }
}
