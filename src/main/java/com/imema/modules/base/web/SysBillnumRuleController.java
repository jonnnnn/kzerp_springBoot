package com.imema.modules.base.web;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.SysBillnumRule;
import com.imema.modules.base.service.SysBillnumRuleService;
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
@RequestMapping("/base/billnum")
public class SysBillnumRuleController {
    @Autowired
    private SysBillnumRuleService ruleService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = ruleService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody SysBillnumRule rule) {
        ruleService.save(rule);
        return R.ok();
    }

    @PostMapping("/checkType")
    public R checkType(@RequestBody Map<String,Object> params){
        int i=ruleService.queryExsistCount(params);
        return i>0?R.ok().putData("当前选择的单据号规则重复！"):R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> params) {
        List<Integer> ids=(List<Integer>)params.get("ids");
        ruleService.removeByIds(ids);
        return R.ok();
    }
}
