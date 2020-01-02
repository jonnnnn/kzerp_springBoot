package com.imema.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.sys.entity.SysDictionaryItemEntity;

import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-09-02 15:24
 * Description: 系统字典
 **/
public interface SysDictionaryItemService extends IService<SysDictionaryItemEntity> {
    PageUtils queryPage(Map<String,Object> params);
    Integer checkCode(Map<String,Object> params);
}
