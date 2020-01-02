package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imema.modules.base.entity.SysBillnumRuleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-12 12:31
 * Description:
 **/
@Mapper
public interface SysBillnumRuleTypeDao extends BaseMapper<SysBillnumRuleType> {
    List<Map<String,Object>> queryCodeName(String name);
}
