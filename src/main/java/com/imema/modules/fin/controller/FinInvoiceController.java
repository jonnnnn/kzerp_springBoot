package com.imema.modules.fin.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.fin.entity.FinInvoice;
import com.imema.modules.fin.service.FinInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-27 11:17
 * Description:
 **/
@RestController
@RequestMapping("/fin/invoice")
public class FinInvoiceController {
    @Autowired
    private FinInvoiceService invoiceService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String,Object> parameter) throws ParseException {
        PageUtils page=invoiceService.getList(parameter);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody FinInvoice invoice){
        invoiceService.save(invoice);
        return R.ok();
    }

    @PostMapping("/checkCode")
    public R checkCode(@RequestBody Map<String,Object> params){
        return R.ok().putData(invoiceService.checkCode(params));
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String,Object> params){
        List<Integer> ids= (List<Integer>) params.get("ids");
        invoiceService.removeByIds(ids);
        return R.ok();
    }
}
