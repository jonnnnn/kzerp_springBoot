/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.inv.dao.TransactionsDao;
import com.imema.modules.inv.entity.InoutBillEntity;
import com.imema.modules.inv.entity.TransactionsEntity;
import com.imema.modules.inv.service.OnhandService;
import com.imema.modules.inv.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;


@Service("transactionsService")
public class TransactionsServiceImpl extends BaseServiceImpl<TransactionsDao, TransactionsEntity> implements TransactionsService {

    @Autowired
    OnhandService onhandService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        IPage<TransactionsEntity> page = baseMapper.queryPage(new Query<TransactionsEntity>().getPage(pageForm),(LinkedHashMap)dataForm.get("data"));
        return new PageUtils(page);
    }

    @Override
    public void add(InoutBillEntity inoutBillEntity) throws RuntimeException {
        try {
            String code= BasicEnum.getInOrOut(inoutBillEntity.getTransactionType());
            if(code.contains("OUT")){
                onhandService.valOnhand(inoutBillEntity);
            }
            onhandService.addOrUpdate(inoutBillEntity);
            this.addTransactionsBatch(inoutBillEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("创建库存流水失败："+e.getMessage());
        }
    }

    public void addTransactionsBatch(InoutBillEntity inoutBillEntity)throws RuntimeException {
        try {
            baseMapper.addTransactionsBatch(inoutBillEntity);
        } catch (Exception e) {
            throw new RuntimeException("批量插入事物失败："+e.getMessage());
        }
    }
}