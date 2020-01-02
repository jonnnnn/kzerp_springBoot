/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.fin.service.impl;

import com.imema.common.enums.EntityState;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.common.validator.ValidatorUtils;
import com.imema.common.validator.group.UpdateGroup;
import com.imema.modules.base.dao.MasCustVendorDao;
import com.imema.modules.base.entity.MasCustVendor;
import com.imema.modules.fin.dao.PayrecDao;
import com.imema.modules.fin.entity.PayrecEntity;
import com.imema.modules.fin.entity.RealPayrecDtlEntity;
import com.imema.modules.fin.entity.RealPayrecOrdEntity;
import com.imema.modules.so.entity.SalesOrderLineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.core.BaseServiceImpl;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;

import com.imema.modules.fin.dao.RealPayrecDao;
import com.imema.modules.fin.entity.RealPayrecEntity;
import com.imema.modules.fin.service.RealPayrecService;
import org.springframework.util.StringUtils;


@Service("realPayrecService")
public class RealPayrecServiceImpl extends BaseServiceImpl<RealPayrecDao, RealPayrecEntity> implements RealPayrecService {

    @Autowired
    RealPayrecOrdServiceImpl realPayrecOrdService;
    @Autowired
    RealPayrecDtlServiceImpl realPayrecDtlService;
    @Autowired
    PayrecDao payrecDao;
    @Autowired
    MasCustVendorDao custVendorDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        Map<String, Object> selectFrom = (Map<String, Object>) dataForm.get("data");

        IPage<RealPayrecEntity> page = baseMapper.queryPage(
                new Query<RealPayrecEntity>().getPage(pageForm),
                selectFrom
        );

        return new PageUtils(page);
    }

    @Override
    public R savePay(RealPayrecEntity realPayrecEntity) {
        boolean isOk;
        realPayrecEntity.setStatus("NEW");
        realPayrecEntity.setState(EntityState.NEW);
        if(StringUtils.isEmpty(realPayrecEntity.getSummary())){
            //拿客户的身份来指定收款类型
            MasCustVendor custVendor = custVendorDao.selectById(realPayrecEntity.getCustId());
            if("CUST".equals(custVendor.getCustVendor())){
                realPayrecEntity.setSummary("16");
            }else if("VENDOR".equals(custVendor.getCustVendor())){
                realPayrecEntity.setSummary("18");
            }else if("SUP".equals(custVendor.getCustVendor())){
                realPayrecEntity.setSummary("20");
            }
        }
        isOk = this.save(realPayrecEntity);

        if(isOk){
            List<RealPayrecOrdEntity> lines = realPayrecEntity.getLineList();
            if(lines != null){
                for (RealPayrecOrdEntity line:lines) {
                    line.setGatheringId(realPayrecEntity.getId());
                    line.setPayrecId(line.getId());
                    line.setOrderNum(line.get("sourceOrderNum")+"");
                    line.setId(null);
                    line.setGatheringAmount(new BigDecimal(line.get("pamount")+""));
                    realPayrecOrdService.save(line);
                    payrecDao.updateStatus(line.getPayrecId());
                }
            }

            RealPayrecDtlEntity dtl = new RealPayrecDtlEntity();
            dtl.setGatheringId(realPayrecEntity.getId());
            dtl.setGatheringType(Integer.valueOf(realPayrecEntity.get("gatheringType")+""));
            dtl.setDeletedFlag("N");
            dtl.setApplyFlag(0);
            dtl.setId(null);
            dtl.setAmount(realPayrecEntity.getAmount());
            realPayrecDtlService.save(dtl);
        }else {
            return R.error("未知异常,保存失败!");
        }

        return null;
    }
}