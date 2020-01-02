package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.base.entity.InvReservations;
import com.imema.modules.base.entity.SysLookupValues;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SysLookUpValuesDao extends BaseMapper<SysLookupValues> {
    @Select("select meaning from sys_lookup_values where lookup_type=#{lookUpType} and lookup_code=#{lookUpCode}")
    String getLookUpNameByCode(@Param("lookUpType") String lookUpType, @Param("lookUpCode") String lookUpCode);


    @Select("SELECT i.name as meaning FROM sys_dictionary s,sys_dictionary_item i " +
            " where s.CODE=#{dictType} and s.ID = i.DICTIONARY_ID " +
            " and i.DELETED_FLAG='N' and i.id = #{dictId} ")
    String getDictNameById(@Param("dictType") String dictType, @Param("dictId") String dictId);




}
