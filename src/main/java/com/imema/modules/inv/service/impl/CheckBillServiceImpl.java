/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.dao.CheckBillDao;
import com.imema.modules.inv.entity.CheckBillEntity;
import com.imema.modules.inv.entity.CheckBillLineEntity;
import com.imema.modules.inv.service.CheckBillLineService;
import com.imema.modules.inv.service.CheckBillService;
import com.imema.modules.inv.service.InoutBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("checkBillService")
public class CheckBillServiceImpl extends BaseServiceImpl<CheckBillDao, CheckBillEntity> implements CheckBillService {
    @Autowired
    private CheckBillLineService checkBillLineService;
    @Autowired
    private InoutBillService inoutBillService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        IPage page = baseMapper.queryPage(new Query<CheckBillEntity>().getPage(pageForm),(LinkedHashMap)dataForm.get("data"));
        return new PageUtils(page);
    }

    @Override
    public void submit(CheckBillEntity checkBillEntity) throws RuntimeException {
        try {
            boolean isAuto=(boolean)checkBillEntity.get("isAuto");
            checkBillEntity=getById(checkBillEntity.getId());
            if(!checkBillEntity.getStatus().equals(OrderEnum.NEW.getvalue())){
                throw new RuntimeException("必须草稿状态才能操作！");
            }
            List<CheckBillLineEntity> checkBillLineEntityList=checkBillLineService.getCheckBillLineEntityListByCheckBillId(checkBillEntity.getId());
            if(checkBillLineEntityList==null || checkBillLineEntityList.size()==0){
                throw new RuntimeException("单据明细不能为空！");
            }
            checkBillEntity.setLineList(checkBillLineEntityList);
            checkBillEntity.setStatus(OrderEnum.COMPLETED.getvalue());
            checkBillEntity.put("isAuto",isAuto);
            inoutBillService.autoCreate(checkBillEntity, BasicEnum.PD_ORDER);
            save(checkBillEntity);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("操作失败："+e.getMessage());
        }
    }

}