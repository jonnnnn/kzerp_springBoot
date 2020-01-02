package com.imema.modules.base.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.modules.base.entity.SysBillnumRule;
import com.imema.modules.base.entity.SysBillnumRuleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/*
 * @author Mr.Lee
 * @time 2019/8/2  0:31
 * */
@Mapper
public interface SysBillnumRuleDao extends BaseMapper<SysBillnumRule> {
    @Select("select * from sys_billnum_rule where type_id=(select id from sys_billnum_rule_type where `code`=#{code}) and company_id=#{companyId}")
    SysBillnumRule isExistRule(@Param("code") String code,@Param("companyId") Integer companyId);

    @Select("insert into `sys_billnum_rule`(`type_id`, `prefix`, `prefix_seprator`, `year_flag`, `y_length`, `month_flag`, `day_flag`, `sequence_length`," +
            "`loop_type`, `suffix_seprator`, `suffix`, `remark`, `year`, `month`, `day`, `sequence_num`, `enabled_flag`, `deleted_flag`," +
            "`start_date_active`, `end_date_active`, `company_id`)" +
            "select `id`, `prefix`, `prefix_seprator`, `year_flag`, `y_length`, `month_flag`, `day_flag`, `sequence_length`, `loop_type`," +
            " `suffix_seprator`, `suffix`, `remark`, `year`, `month`, `day`, `sequence_num`, `enabled_flag`, `deleted_flag`," +
            " `start_date_active`, `end_date_active`,#{companyId} from sys_billnum_rule_type where `code`=#{code}")
    SysBillnumRule insertNextNum(@Param("code") String code,@Param("companyId") Integer companyId);
    @Select("select * from sys_billnum_rule where company_id=#{companyId} and type_id=(select id from sys_billnum_rule_type where `code`=#{code})")
    SysBillnumRule getNextNum(@Param("code") String code,@Param("companyId") Integer companyId);

    IPage<SysBillnumRule> selectByCodeName(IPage<SysBillnumRule> page, @Param("p") Map<String, Object> params);

    Integer selectCountByType(@Param("p") Map<String,Object> param);
}
