package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.MtlProductPrice;
import com.imema.modules.inv.entity.OnhandEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-12 10:06
 * Description:
 **/
@Mapper
public interface MtlProductPriceDao extends BaseMapper<MtlProductPrice> {
    IPage<MtlProductPrice> selectCode(IPage<MtlProductPrice> page, @Param("p") Map<String, Object> params);
    public MtlProductPrice getProductPrice(@Param("onhandEntity") OnhandEntity onhandEntity);
    int checkProductId(@Param("param")Map<String,Object> params);
}
