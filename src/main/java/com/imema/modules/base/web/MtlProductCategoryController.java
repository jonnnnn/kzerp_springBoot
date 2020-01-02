package com.imema.modules.base.web;

import cn.hutool.core.util.PinyinUtil;
import com.imema.common.utils.CommonUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProductCategory;
import com.imema.modules.base.service.MtlProductCategoryService;
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
 * @time 2019/8/3  17:53
 * */
@RestController
@RequestMapping("/base/productcategory")
public class MtlProductCategoryController {
    @Autowired
    private MtlProductCategoryService categoryService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = categoryService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MtlProductCategory category) {
        String allFirstLetter = PinyinUtil.getAllFirstLetter(category.getName());
        String wbCode = CommonUtils.getWBCode(category.getName());

        category.setWbCode(wbCode);
        category.setPinyinCode(allFirstLetter);
        categoryService.save(category);
        return R.ok();
    }

    @PostMapping("/checkCode")
    public R check(@RequestBody Map<String,Object> params) {
        return R.ok().putData(categoryService.checkCode(params));
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        categoryService.removeByIds(ids);
        return R.ok();
    }
}
