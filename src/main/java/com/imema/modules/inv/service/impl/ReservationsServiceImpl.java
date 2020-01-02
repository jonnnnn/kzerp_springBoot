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
import com.imema.data.IBaseModel;
import com.imema.modules.dto.OnhandDto;
import com.imema.modules.dto.OnhandLineDto;
import com.imema.modules.inv.dao.OnhandDao;
import com.imema.modules.inv.dao.ReservationsDao;
import com.imema.modules.inv.entity.ReservationsEntity;
import com.imema.modules.inv.service.OnhandService;
import com.imema.modules.inv.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("reservationsService")
public class ReservationsServiceImpl extends BaseServiceImpl<ReservationsDao, ReservationsEntity> implements ReservationsService {

    @Autowired
    public OnhandDao onhandDao;

    @Autowired
    private OnhandService onhandService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ReservationsEntity> page = this.page(
                new Query<ReservationsEntity>().getPage(params),
                new QueryWrapper<ReservationsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void add(Object objectClass) throws RuntimeException {
        try {
            onhandService.valOnhand(objectClass);
            IBaseModel iBaseModel=(IBaseModel)objectClass;
            List<Object> objLineList=((List)iBaseModel.get("lineList"));
            for (Object objLine : objLineList) {
                IBaseModel iBaseModelLine=(IBaseModel)objLine;
                ReservationsEntity reservationsEntity=new ReservationsEntity();
                reservationsEntity.setRequirementDate(new Date());
                reservationsEntity.setCompanyId((int)iBaseModel.get("companyId"));
                reservationsEntity.setProductId((int)iBaseModelLine.get("productId"));
                reservationsEntity.setWarehouseId((int)iBaseModel.get("warehouseId"));
                reservationsEntity.setTranType(iBaseModel.get("tranType").toString());
                reservationsEntity.setDemandSourceHeaderId((int)iBaseModel.get("id"));
                reservationsEntity.setDemandSourceLineId((int)iBaseModelLine.get("id"));
                reservationsEntity.setReservationUomCode(iBaseModelLine.get("uom").toString());
                reservationsEntity.setReservationQuantity((int)iBaseModelLine.get("orderQty"));
                this.save(reservationsEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("创建保留失败！"+e.getMessage());
        }
    }

    @Override
    @Transactional
    public void del(Object objectClass) throws RuntimeException {
        try {
            IBaseModel iBaseModel=(IBaseModel)objectClass;
            List<Object> objLineList=((List)iBaseModel.get("lineList"));
            Map<String, Object> columnMap = new HashMap<String, Object>();
            for (Object objLine : objLineList) {
                IBaseModel iBaseModelLine=(IBaseModel)objLine;
                columnMap.put("demandSourceHeaderId",iBaseModel.get("id"));
                columnMap.put("demandSourceLineId",iBaseModelLine.get("id"));
                columnMap.put("tranType",iBaseModel.get("tranType"));
                this.removeByMap(columnMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除保留失败！"+e.getMessage());
        }
    }


    /**
     * 判断库存是否够
     * @param objectClass
     * @return
     */
    public boolean checkStock(Object objectClass){
        IBaseModel iBaseModel=(IBaseModel)objectClass;
        List<Object> objLineList=((List)iBaseModel.get("lineList"));
        Map<String,Integer> stockMap = new HashMap<>();
        String keyStr;
        for (Object objLine : objLineList) {
            IBaseModel iBaseModelLine=(IBaseModel)objLine;
            keyStr = iBaseModelLine.get("productId")+"-"+iBaseModelLine.get("warehouseId");
            if(stockMap.containsKey(keyStr)){
                stockMap.put(keyStr,stockMap.get(keyStr)+(int)iBaseModelLine.get("orderQty"));
            }else{
                stockMap.put(keyStr,(int)iBaseModelLine.get("orderQty"));
            }
        }
        for(Map.Entry<String, Integer> entry : stockMap.entrySet()){
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("productId",mapKey.split("-")[0]);
            paramMap.put("warehouseId",mapKey.split("-")[1]);
            Integer stock = onhandDao.getSockByPW(paramMap);
            if(stock<mapValue){
                return false;
            }
        }

        return true;
    }

}