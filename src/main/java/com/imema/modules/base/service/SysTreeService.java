package com.imema.modules.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.common.utils.PageUtils;
import com.imema.modules.base.entity.SysTree;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-07-31 17:30
 * Description: 主从结构通用表Service
 **/
public interface SysTreeService extends IService<SysTree>{

    PageUtils queryList(Map<String,Object> params);

    Integer checkCode(Map<String, Object> params);

    List<SysTree> getList(Map<String, Object> params);
}
