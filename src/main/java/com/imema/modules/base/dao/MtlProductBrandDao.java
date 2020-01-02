package com.imema.modules.base.dao;/*
 * @author Mr.Lee
 * @time 2019/8/2  0:26
 * */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MtlProductBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MtlProductBrandDao extends BaseMapper<MtlProductBrand> {
    IPage<MtlProductBrand> queryPage(IPage<MtlProductBrand> page, @Param("p") Map<String,Object> params);
}
