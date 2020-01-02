package com.imema.modules.common.service;

import com.imema.core.BaseServiceImpl;
import com.imema.modules.app.entity.UserEntity;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.dao.CommonDao;
import com.imema.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl extends BaseServiceImpl<CommonDao, Object> {

    public List<Map<String, Object>> queryBizDropdown(BasicEnum typeEnum, String query) {
        return baseMapper.queryBizDropdown(typeEnum,query);
    }

    /*无权限过滤*/
    public List<Map<String, Object>> queryBizDropdownAlias(BasicEnum typeEnum, String query) {
        return baseMapper.queryBizDropdownAlias(typeEnum,query);
    }

    /*包含公共数据*/
    public List<Map<String, Object>> queryBizDropdownAll(BasicEnum typeEnum, String query) {
        return baseMapper.queryBizDropdownAll(typeEnum,query);
    }

    public List<Map<String, Object>> queryCodeDropdown(String type,Map<String, Object> query) {
        return baseMapper.queryCodeDropdown(type,query);
    }

    public List<Map<String, Object>> queryDictDropdown(BasicEnum typeEnum,Map<String, Object> query) {
        SysUserEntity userEntity = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
        return baseMapper.queryDictDropdown(userEntity,typeEnum,query);
    }

}
