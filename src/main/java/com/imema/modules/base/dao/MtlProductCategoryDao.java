package com.imema.modules.base.dao;/*
 * @author Mr.Lee
 * @time 2019/8/2  0:28
 * */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MtlProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MtlProductCategoryDao extends BaseMapper<MtlProductCategory> {
    List<MtlProductCategory> queryPage( @Param("p")Map<String,Object> params);

    Integer checkCode(@Param("s") Map<String, Object> params);

    Map<String, Object> selectPcategory(String name);
}
