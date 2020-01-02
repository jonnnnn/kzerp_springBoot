package com.imema.modules.fin.controller;

import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.modules.fin.entity.FinSubject;
import com.imema.modules.fin.service.FinSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-27 11:17
 * Description:
 **/
@RestController
@RequestMapping("/fin/subject")
public class FinSubjectController {

    @Autowired
    private FinSubjectService subjectService;

    @PostMapping("/list")
    public R list(@RequestBody Map<String, Object> parameter) {
        PageUtils result = subjectService.getList(parameter);
        return R.ok().putData(result);
    }

    @PostMapping("/save")
    public R save(@RequestBody FinSubject account) {
        subjectService.save(account);
        return R.ok();
    }

    @PostMapping("/delete")
    public R delete(@RequestBody Map<String, Object> params) {
        List<Integer> ids = (List<Integer>) params.get("ids");
        subjectService.removeByIds(ids);
        return R.ok();
    }
}
