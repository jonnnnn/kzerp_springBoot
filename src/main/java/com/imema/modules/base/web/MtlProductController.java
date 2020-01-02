package com.imema.modules.base.web;

import cn.hutool.core.util.PinyinUtil;
import com.imema.common.utils.CommonUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProduct;
import com.imema.modules.base.service.MtlProductCategoryService;
import com.imema.modules.base.service.MtlProductService;
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
@RequestMapping("/base/product")
public class MtlProductController {
    @Autowired
    private MtlProductService productService;
    @Autowired
    private MtlProductCategoryService categoryService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameters) {
        PageUtils page = productService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MtlProduct product) {
        String cateCode = String.valueOf(product.get("cateCode"));
        Map<String, Object> result = categoryService.selectPcategoryId(cateCode);
        String allFirstLetter = PinyinUtil.getAllFirstLetter((String)result.get("name"));
        String wbCode = CommonUtils.getWBCode((String)result.get("name"));

        product.setCategoryId((Integer)result.get("p_cate"));
        product.setName(cateCode);

        product.setPinyinCode(allFirstLetter);
        product.setWbCode(wbCode);
        productService.save(product);
        return R.ok();
    }

    @PostMapping("/checkCode")
    public R validator(@RequestBody Map<String,Object> params){
        int result=productService.checkCode(params);
        return result>0?R.ok().putData("内容不能重复，请重新搜索指定！"):R.ok();
    }

  @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        productService.removeByIds(ids);
        return R.ok();
    }


    /**
     * 信息
     */
    @RequestMapping("/search")
    public R prod(@RequestBody Map<String, Object> params){
        List<MtlProduct> prod = productService.searchProduct(params);

        return R.ok().putData(prod);
    }

}
