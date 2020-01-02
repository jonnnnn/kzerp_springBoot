package com.imema.modules.base.web;

import cn.hutool.core.util.PinyinUtil;
import com.imema.common.utils.CommonUtils;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.base.entity.MtlProductPrice;
import com.imema.modules.base.service.MtlProductPriceService;
import com.imema.modules.form.FormParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-12 10:11
 * Description:
 **/
@RestController
@RequestMapping("/base/productprice")
public class MtlProductPriceController {
    @Autowired
    private MtlProductPriceService priceService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String,Object> parameters) {
        PageUtils page = priceService.getList(parameters);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody MtlProductPrice price) {
        Map<String,Object> params=new HashMap<>();
        params.put("productId",price.getProductId());
        boolean result=priceService.checkProductId(params);
        if(result){
            return R.error("当前产品已经存在相应的价格记录，所填记录无效");
        }
        priceService.save(price);
        return R.ok();
    }

    @PostMapping("/checkProduct")
    public R checkProduct(@RequestBody Map<String,Object> params){
        return R.ok().putData(priceService.checkProductId(params));
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> idMap){
        List<Integer> ids= (List<Integer>) idMap.get("ids");
        priceService.removeByIds(ids);
        return R.ok();
    }
}
