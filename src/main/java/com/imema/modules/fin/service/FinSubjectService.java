package com.imema.modules.fin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.fin.entity.FinSubject;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-29 17:06
 * Description:
 **/
public interface FinSubjectService extends IService<FinSubject> {
    PageUtils getList(Map<String,Object> params);
}
