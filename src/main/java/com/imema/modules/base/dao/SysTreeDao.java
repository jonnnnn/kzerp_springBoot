package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.SysTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-07-31 17:25
 * Description: 主从结构通用表操作
 **/
@Mapper
public interface SysTreeDao extends BaseMapper<SysTree> {
    List<SysTree> selectTreeByMapOps(@Param("p") Map<String,Object> params);

    Integer selectByCode(@Param("c") Map<String, Object> params);
}
