package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MasCustVendorContact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MasCustVendorContactDao extends BaseMapper<MasCustVendorContact> {
    IPage<MasCustVendorContact> selectByMap(IPage<MasCustVendorContact> page, @Param("p")Map<String,Object> params);
}
