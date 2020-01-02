package com.imema.modules.fin.controller;

import com.imema.common.enums.EntityState;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.fin.entity.FinAccount;
import com.imema.modules.fin.service.FinAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-27 11:17
 * Description:
 **/
@RestController
@RequestMapping("/fin/account")
public class FinAccountController {

    @Autowired
    private FinAccountService accountService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameter) {
        PageUtils page = accountService.getList(parameter);
        return R.ok().putData(page);
    }

    @PostMapping("/save")
    public R save(@RequestBody FinAccount account) {
        if (account.getState().equals(EntityState.DELETED)){
            account.setStatus(0);
        }

        accountService.save(account);
        return R.ok();
    }

    @PostMapping("/nameValid")
    public R validateName(@RequestBody Map<String ,Object> params) {
        String name=(String)params.get("name");
        int i = accountService.selectCountByName(name);
        return i>0?R.ok().putData("账户名称重复，请复核"):R.ok();
    }
}
