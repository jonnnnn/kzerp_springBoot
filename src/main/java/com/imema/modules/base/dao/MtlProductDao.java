package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MtlProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MtlProductDao extends BaseMapper<MtlProduct> {

    List<MtlProduct> getProduct(Map<String ,Object> param);

    IPage<MtlProduct> selectByMapOpsLike(IPage<MtlProduct> page,@Param("p") Map<String,Object> map);


    String getProductIds(String qureyStr);

    Integer validateCode(@Param("c") Map<String,Object> params);
}
