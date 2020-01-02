package com.imema.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.sys.entity.SysDictionaryEntity;

import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-09-02 15:23
 * Description:
 **/
public interface SysDictionaryService extends IService<SysDictionaryEntity> {
    PageUtils queryPage(Map<String,Object> params);
}
