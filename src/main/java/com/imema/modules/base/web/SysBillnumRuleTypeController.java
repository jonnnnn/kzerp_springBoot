package com.imema.modules.base.web;

import com.imema.common.utils.R;
import com.imema.modules.base.entity.SysBillnumRuleType;
import com.imema.modules.base.service.SysBillnumRuleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.Lee
 * @since 2019-08-12 12:35
 * Description:
 **/
@RestController
@RequestMapping("/base/ruletype")
public class SysBillnumRuleTypeController {
    @Autowired
    private SysBillnumRuleTypeService typeService;

    @PostMapping("/list")
    public R list(String name) {
        List<SysBillnumRuleType> result=typeService.getCodeName(name);
        return R.ok().putData(result);
    }
}
