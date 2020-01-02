package com.imema.modules.fin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.fin.entity.FinInvoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
@Mapper
public interface FinInvoiceDao extends BaseMapper<FinInvoice> {
    IPage<FinInvoice> queryList(IPage<FinInvoice> page, @Param("p") Map<String,Object> params);

    Integer selectCountByCode(@Param("c") Map<String, Object> params);
}
