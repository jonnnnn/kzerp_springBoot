package com.imema.modules.common;

import com.imema.common.utils.ShiroUtils;
import com.imema.modules.sys.entity.SysUserEntity;
import org.apache.commons.codec.binary.Base64;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Map;

public class BaseDropdownProvider {
    /**
     * 获取下拉框SQL
     *
     * @param typeEnum
     * @param query
     * @return
     */
    public String getDropdownByCondition(@Param("typeEnum") BasicEnum typeEnum, @Param("query") String query) {
        String sql = typeEnum.getAttr().replaceAll("#query#", query);
        return sql + " and company_id=" + ShiroUtils.getCompanyId();
    }

    /**
     * 获取下拉框SQL
     * 无权限过滤
     *
     * @param typeEnum
     * @param query
     * @return
     */
    public String getDropdownByConditionAlias(@Param("typeEnum") BasicEnum typeEnum, @Param("query") String query) {
        return typeEnum.getAttr().replaceAll("#query#", query);
    }

    /**
     * 获取下拉框SQL
     * 包括companyId=0的公共数据
     *
     * @param typeEnum
     * @param query
     * @return
     */
    public String getDropdownByConditionOutter(@Param("typeEnum") BasicEnum typeEnum, @Param("query") String query) {
        String sql = typeEnum.getAttr().replaceAll("#query#", query);
        return sql + " and (company_id=" + ShiroUtils.getCompanyId() + " or company_id=0)";
    }

    /**
     * 获取业务下拉框SQL 带权限过滤
     *
     * @param typeEnum
     * @param query
     * @return
     */

    public String getDictDropdown(@Param("userEntity") SysUserEntity userEntity, @Param("typeEnum") BasicEnum typeEnum, @Param("query") Map<String, Object> query) {
        String sql = "SELECT i.id AS `value`,i.name as `key` FROM sys_dictionary s,sys_dictionary_item i " +
                " where s.CODE='" + typeEnum.getValue() + "' and s.ID = i.DICTIONARY_ID \n" +
                " and i.DELETED_FLAG='N' and i.COMPANY_ID in(0," + userEntity.getCompanyId() + ")";
        System.out.println("sql=" + sql);
        return sql;
    }

}

