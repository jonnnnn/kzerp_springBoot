package com.imema.modules.fin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.fin.entity.FinSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-29 17:04
 * Description:
 **/
@Mapper
public interface FinSubjectDao extends BaseMapper<FinSubject> {
    List<FinSubject> queryList(@Param("p") Map<String, Object> params);
}
