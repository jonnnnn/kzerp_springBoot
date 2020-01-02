package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MasWarehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MasWarehouseDao extends BaseMapper<MasWarehouse> {
    IPage<MasWarehouse> queryPage(IPage<MasWarehouse> page, @Param("p") Map<String,Object> params);
}
