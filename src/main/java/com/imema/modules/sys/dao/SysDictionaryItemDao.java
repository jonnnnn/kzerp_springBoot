package com.imema.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.sys.entity.SysDictionaryItemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-09-02 15:22
 * Description:
 **/
@Mapper
public interface SysDictionaryItemDao extends BaseMapper<SysDictionaryItemEntity> {
    IPage<SysDictionaryItemEntity> queryPage(IPage<SysDictionaryItemEntity> page, @Param("p")Map<String,Object> params);
    Integer checkCode(@Param("pr")Map<String,Object> params);
}
