/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.core;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.enums.EntityState;
import com.imema.common.utils.*;
import com.imema.common.validator.ValidatorUtils;
import com.imema.common.validator.group.AddGroup;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.data.IBaseModel;
import com.imema.modules.common.dao.CommonDao;
import com.imema.modules.so.entity.SalesOrderEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IBaseService<T> {


    @Autowired
    public BillnumHelper billnumHelper;


    @Autowired
    public CommonDao commonDao;


    public void save(List<T> list){
        for (T entity : list){
            this.save(entity);
        }
    }
    @Override
    public boolean save(T model){
        if (model == null) {
            return false;
        }
        if(!IBaseModel.class.isAssignableFrom(model.getClass())) {
            return super.saveOrUpdate(model);
        }
        IBaseModel entity = (IBaseModel)model;
        Date markTime = new Date();
        //Class entityClz = ClassUtils.getUserClass(entity);
        EntityState state = EntityState.NONE;
        Integer id=null;
        try {
            id = (Integer)entity.get("id");
        } catch (Exception e1) {
        }
        if(null!=entity.getState()) {
            state = entity.getState();
        } else {
            if(id != null){
                state = EntityState.MODIFIED;
            }
        }
        switch (state) {
            case NONE: //和下面新增的逻辑一样，不写break，程序会往下继续执行

            case NEW:
                ValidatorUtils.validateEntity(model, AddGroup.class);
                try {
                    //自动生成单据编号 要求实体类定义BILL_CODE 和 BILL_COLUMN
                    Field codeField = model.getClass().getDeclaredField("BILL_CODE");
                    Field codeColumn = model.getClass().getDeclaredField("BILL_COLUMN");
                    String codeColumnStr = ReflectionUtils.getFieldValue(entity, "BILL_COLUMN")+"";
                    if(codeField != null && codeColumn != null){
                        Object code = ReflectionUtils.getFieldValue(entity, codeColumnStr);
                        if(!objIsNotBlank(code)){
                            String codeNum = billnumHelper.getNextNum(model.getClass());
                            ReflectionUtils.invokeSetterMethod(entity, codeColumnStr, codeNum);
                        }
                    }
                }catch (Exception e){
                }
                try {
                    if(ReflectionUtils.hasField(entity, "createDate")) {
                        Object creationDate = ReflectionUtils.getFieldValue(entity, "createDate");
                        if(creationDate == null) {
                            ReflectionUtils.invokeSetterMethod(entity, "createDate", markTime);
                        }
                    }
                    if(ReflectionUtils.hasField(entity, "createBy")) {
                        Object createBy = ReflectionUtils.getFieldValue(entity, "createBy");
                        if(createBy == null) {
                            ReflectionUtils.invokeSetterMethod(entity, "createBy",
                                    ShiroUtils.getUserEntity().getUsername());
                        }
                    }
                    if(ReflectionUtils.hasField(entity, "updateDate")) {
                        Object lastUpdateDate = ReflectionUtils.getFieldValue(entity, "updateDate");
                        if(lastUpdateDate == null) {
                            ReflectionUtils.invokeSetterMethod(entity, "updateDate", markTime);
                        }
                    }
                    if(ReflectionUtils.hasField(entity, "updateBy")) {
                        Object lastUpdateBy = ReflectionUtils.getFieldValue(entity, "updateBy");
                        if(lastUpdateBy == null) {
                            ReflectionUtils.invokeSetterMethod(entity, "updateBy",
                                    ShiroUtils.getUserEntity().getUsername());
                        }
                    }

                    if(ReflectionUtils.hasField(entity, "deletedFlag"))
                        ReflectionUtils.invokeSetterMethod(entity, "deletedFlag", "N");

                    if(ReflectionUtils.hasField(entity, "pic") && ReflectionUtils.getFieldValue(entity, "pic")==null)
                        ReflectionUtils.invokeSetterMethod(entity, "pic", ShiroUtils.getUserEntity().getUsername());

                    if(ReflectionUtils.hasField(entity, "companyId") && ReflectionUtils.getFieldValue(entity, "companyId")==null)
                        ReflectionUtils.invokeSetterMethod(entity, "companyId",
                                ShiroUtils.getDeptId());

                    //防止id为0的实体
                    if(id != null && id.intValue() == 0){
                        ReflectionUtils.invokeSetterMethod(entity, "id", null, Integer.class);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                super.save(model);
                break;
            case DELETED:
                try {
                    if (ReflectionUtils.hasField(entity, "deletedFlag")) {
                        // 逻辑删除
                        ReflectionUtils.invokeSetterMethod(entity, "deletedFlag", "Y");
                        try {
                            if(ReflectionUtils.hasField(entity, "updateDate")) {
                                Object lastUpdateDate = ReflectionUtils.getFieldValue(entity, "updateDate");
                                if(lastUpdateDate == null) {
                                    ReflectionUtils.invokeSetterMethod(entity, "updateDate", markTime);
                                }
                            }
                            if(ReflectionUtils.hasField(entity, "updateBy")) {
                                Object lastUpdateBy = ReflectionUtils.getFieldValue(entity, "updateBy");
                                if(lastUpdateBy == null) {
                                    ReflectionUtils.invokeSetterMethod(entity, "updateBy",
                                            ShiroUtils.getUserEntity().getUsername());
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        saveOrUpdate(model);
                    } else {
                        // 没有找到setDeletedFlag
                        // 物理删除
                        removeById(id);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                // 查找更新方法
                ValidatorUtils.validateEntity(model, UpdateGroup.class);
                try {
                    if(ReflectionUtils.hasField(entity, "updateDate")) {
                        Object lastUpdateDate = ReflectionUtils.getFieldValue(entity, "updateDate");
                        if(lastUpdateDate == null) {
                            ReflectionUtils.invokeSetterMethod(entity, "updateDate", markTime);
                        }
                    }
                    if(ReflectionUtils.hasField(entity, "updateBy")) {
                        Object lastUpdateBy = ReflectionUtils.getFieldValue(entity, "updateBy");
                        if(lastUpdateBy == null) {
                            ReflectionUtils.invokeSetterMethod(entity, "updateBy",
                                    ShiroUtils.getUserEntity().getUsername());
                        }
                    }
                    saveOrUpdate(model);
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }
        return true;
    }
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");

        IPage<T> page = this.page(
                new Query<T>().getPage(pageForm), toWrapper(dataForm));

        return new PageUtils(page);
    }


    private QueryWrapper<T> toWrapper(Map<String, Object> dataForm) {
        QueryWrapper query = new QueryWrapper<T>();
        Map<String, Object> data = (Map<String, Object>) dataForm.get("data");
        Map<String, String> op = (Map<String, String>) dataForm.get("op");
        for(Map.Entry<String, Object> entry : data.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            if(StringUtils.isNotBlank(op.get(k))) {
                switch (op.get(entry.getKey())) {
                    case "like":
                        query.like(objIsNotBlank(v), k, v);
                        break;
                    case "eq":
                        query.eq(objIsNotBlank(v), k, v);
                        break;
                    default:
                            break;
                }
            }
        }
        return query;
    }

    public boolean objIsNotBlank(Object obj) {
        if(obj != null && StringUtils.isNotBlank(obj.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为新增对象
     * @param model
     * @return
     */
    public boolean isNewObj(T model){
        IBaseModel entity = (IBaseModel)model;
        EntityState state = EntityState.NONE;
        if(null!=entity.getState()) {
            state = entity.getState();
        }
        if(state.equals(EntityState.NEW)){
            return true;
        }
        return false;
    }

    /**
     * 判断是否为修改对象
     * @param model
     * @return
     */
    public boolean isMdfObj(T model){
        IBaseModel entity = (IBaseModel)model;
        EntityState state = EntityState.NONE;
        if(null!=entity.getState()) {
            state = entity.getState();
        }
        if(state.equals(EntityState.MODIFIED)){
            return true;
        }
        return false;
    }

}
