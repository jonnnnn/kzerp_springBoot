package com.imema.modules.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.app.entity.UserEntity;
import com.imema.modules.common.BaseDropdownProvider;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommonDao extends BaseMapper<Object> {
    @SelectProvider(type = BaseDropdownProvider.class,method = "getDropdownByCondition")
    List<Map<String, Object>> queryBizDropdown(@Param("typeEnum") BasicEnum typeEnum,@Param("query") String query);

    /*无权限过滤*/
    @SelectProvider(type = BaseDropdownProvider.class,method = "getDropdownByConditionAlias")
    List<Map<String, Object>> queryBizDropdownAlias(@Param("typeEnum") BasicEnum typeEnum,@Param("query") String query);

    /*包含公共数据*/
    @SelectProvider(type = BaseDropdownProvider.class,method = "getDropdownByConditionOutter")
    List<Map<String, Object>> queryBizDropdownAll(@Param("typeEnum") BasicEnum typeEnum,@Param("query") String query);

    @Select("select lookup_code as `value`,meaning as `key` from sys_lookup_values where lookup_type=#{type} order by seq_num")
    List<Map<String, Object>> queryCodeDropdown(@Param("type") String type,Map<String, Object> query);


    @SelectProvider(type = BaseDropdownProvider.class,method = "getDictDropdown")
    List<Map<String, Object>> queryDictDropdown(@Param("userEntity") SysUserEntity userEntity, @Param("typeEnum") BasicEnum typeEnum, @Param("query") Map<String, Object> query);


    @Select("${sql}")
    List<LinkedHashMap<String, Object>> getListBySql(@Param("sql") String sql);

    @Select("${sql}")
    LinkedHashMap<String, Object> getMapBySql(@Param("sql") String sql);

    @Select("${sql}")
    Object getValue(@Param("sql") String sql);

}
