package com.imema.modules.base.web;

import cn.hutool.core.util.PinyinUtil;
import com.imema.common.utils.CommonUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProductMadein;
import com.imema.modules.base.service.MtlProductMadeinService;
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
@RequestMapping("/base/productmadein")
public class MtlProductMadeinController {
    @Autowired
    private MtlProductMadeinService madeinService;


    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = madeinService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MtlProductMadein madein) {
        String allFirstLetter = PinyinUtil.getAllFirstLetter(madein.getName());
        String wbCode = CommonUtils.getWBCode(madein.getName());

        madein.setWbCode(wbCode);
        madein.setPinyinCode(allFirstLetter);
        madeinService.save(madein);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
         madeinService.removeByIds(ids);
        return R.ok();
    }
}
