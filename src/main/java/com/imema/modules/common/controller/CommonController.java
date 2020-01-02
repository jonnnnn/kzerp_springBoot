package com.imema.modules.common.controller;

import com.imema.common.utils.R;
import com.imema.modules.app.entity.UserEntity;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.service.CommonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("common")
@Api("公用接口")
public class CommonController {

    @Autowired
    private CommonServiceImpl commonService;

    @PostMapping("/biz/{type}")
    @ApiOperation("个性化业务下拉框")
    public R bizDropdown(@PathVariable String type, @RequestBody Map<String, Object> query) {
        Object q = query.get("query");
        if(q != null)
            return R.ok().putData(commonService.queryBizDropdown(BasicEnum.getBasicEnumByCode(type),q.toString()));
        return R.ok();
    }

    @PostMapping("/bizweak/{type}")
    @ApiOperation("个性化业务下拉框 && 无权限过滤")
    public R bizDropdownAlias(@PathVariable String type, @RequestBody Map<String, Object> query) {
        Object q = query.get("query");
        if(q != null)
            return R.ok().putData(commonService.queryBizDropdownAlias(BasicEnum.getBasicEnumByCode(type),q.toString()));
        return R.ok();
    }

    @PostMapping("/bizall/{type}")
    @ApiOperation("companyId=0的公共数据")
    public R bizDropdownAll(@PathVariable String type, @RequestBody Map<String, Object> query) {
        Object q = query.get("query");
        if(q != null)
            return R.ok().putData(commonService.queryBizDropdownAll(BasicEnum.getBasicEnumByCode(type),q.toString()));
        return R.ok();
    }

    @PostMapping("/code/{type}")
    @ApiOperation("标准快码下拉框")
    public R codeDropdown(@PathVariable String type, @RequestBody Map<String, Object> query) {
        return R.ok().putData(commonService.queryCodeDropdown(type,query));
    }

    ;
    @PostMapping("/dict/{type}")
    @ApiOperation("业务快码下拉框")
    public R dictDropdown(@PathVariable String type, @RequestBody Map<String, Object> query) {
        return R.ok().putData(commonService.queryDictDropdown(BasicEnum.getBasicEnumByCode(type),query));
    }
}
