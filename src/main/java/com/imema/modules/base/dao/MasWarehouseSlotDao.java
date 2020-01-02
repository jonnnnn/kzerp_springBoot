package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MasWarehouseSlot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface MasWarehouseSlotDao extends BaseMapper<MasWarehouseSlot> {
    IPage<MasWarehouseSlot> queryByMap(IPage<MasWarehouseSlot> page, @Param("p")Map<String,Object> params);
}
