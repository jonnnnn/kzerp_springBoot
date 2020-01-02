package com.imema.modules.fin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.fin.entity.FinAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface FinAccountDao extends BaseMapper<FinAccount> {
    IPage<FinAccount> queryList(IPage<FinAccount> page, @Param("p") Map<String,Object> params);
    Integer selectCountByName(String name);
}
