package com.imema.modules.base.web;

import cn.hutool.core.util.PinyinUtil;
import com.imema.common.utils.CommonUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProductBrand;
import com.imema.modules.base.service.MtlProductBrandService;
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
 * @time 2019/8/3  17:52
 * */
@RestController
@RequestMapping("/base/productbrand")
public class MtlProductBrandController {
    @Autowired
    private MtlProductBrandService brandService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = brandService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MtlProductBrand brand) {
        String allFirstLetter = PinyinUtil.getAllFirstLetter(brand.getName());
        String wbCode = CommonUtils.getWBCode(brand.getName());

        brand.setWbCode(wbCode);
        brand.setPinyinCode(allFirstLetter);
        brandService.save(brand);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        brandService.removeByIds(ids);
        return R.ok();
    }
}
