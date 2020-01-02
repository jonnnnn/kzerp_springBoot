package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MasCustVendor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MasCustVendorDao extends BaseMapper<MasCustVendor> {
    IPage<MasCustVendor> queryPage(IPage<MasCustVendor> page, @Param("p") Map<String,Object> params);
}
