package com.imema.modules.base.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MtlProductVehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * @author Mr.Lee
 * @time 2019/8/2  0:30
 * */
@Mapper
public interface MtlProductVehicleDao extends BaseMapper<MtlProductVehicle> {
    List<MtlProductVehicle> queryPage( @Param("p") Map<String,Object> params);

    List<MtlProductVehicle> getList(Integer pid);
}
