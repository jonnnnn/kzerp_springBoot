/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.*;
import com.imema.core.BaseServiceImpl;
import com.imema.data.DefaultBaseModel;
import com.imema.data.IBaseModel;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.dao.InoutBillDao;
import com.imema.modules.inv.entity.*;
import com.imema.modules.inv.service.InoutBillLineService;
import com.imema.modules.inv.service.InoutBillService;
import com.imema.modules.inv.service.TransactionsService;
import com.imema.modules.inv.service.TransferBillService;
import com.imema.modules.pur.entity.PoHeaderEntity;
import com.imema.modules.pur.entity.PoLineEntity;
import com.imema.modules.pur.service.PoHeaderService;
import com.imema.modules.pur.service.PoLineService;
import com.imema.modules.so.entity.SalesOrderEntity;
import com.imema.modules.so.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;


@Service("inoutBillService")
public class InoutBillServiceImpl extends BaseServiceImpl<InoutBillDao, InoutBillEntity> implements InoutBillService {

    @Autowired
    private InoutBillLineService inoutBillLineService;
    @Autowired
    private TransactionsService transactionsService;
    @Autowired
    private PoHeaderService poHeaderService;
    @Autowired
    private TransferBillService transferBillService;
    @Autowired
    private SalesOrderService salesOrderService;
    @Autowired
    private PoLineService poLineService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        IPage<InoutBillEntity> page = baseMapper.queryPage(new Query<InoutBillEntity>().getPage(pageForm),(LinkedHashMap)dataForm.get("data"));
        return new PageUtils(page);
    }
    @Override
    public void createActionByTransferBill(TransferBillEntity transferBillEntity, BasicEnum basicEnum) throws RuntimeException {
        try {
            InoutBillEntity inoutBillEntity=new InoutBillEntity();
            inoutBillEntity.setTransactionType(basicEnum.getValue());
            inoutBillEntity.setSourceOrderType(basicEnum.getAttr());
            inoutBillEntity.setSourceOrderId(transferBillEntity.getId());
            inoutBillEntity.setSourceOrderNum(transferBillEntity.getOrderNum());
            if(isAutoAction(transferBillEntity.get("isAuto"))){
                inoutBillEntity.setStatus(OrderEnum.COMPLETED.getvalue());
                inoutBillEntity.setInDate(new Date());
            }else{
                inoutBillEntity.setStatus(OrderEnum.NEW.getvalue());
            }
            String code= BasicEnum.getInOrOut(inoutBillEntity.getTransactionType());
            if(code.contains("OUT")){
                inoutBillEntity.setWarehouseId(transferBillEntity.getFromWarehouseId());
                inoutBillEntity.setCompanyId(transferBillEntity.getOutCompanyId());
            }else{
                inoutBillEntity.setWarehouseId(transferBillEntity.getToWarehouseId());
                inoutBillEntity.setCompanyId(transferBillEntity.getInCompanyId());
            }
            inoutBillEntity.setDeletedFlag("N");
            inoutBillEntity.setPic(ShiroUtils.getUserEntity().getUsername());
            this.save(inoutBillEntity);
            List<TransferBillLineEntity> transferBillLineEntityList=transferBillEntity.getLineList();
            List<InoutBillLineEntity> inoutBillLineEntityList=new ArrayList<InoutBillLineEntity>();
            for (TransferBillLineEntity transferBillLineEntity : transferBillLineEntityList) {
                InoutBillLineEntity inoutBillLineEntity=new InoutBillLineEntity();
                inoutBillLineEntity.setBillId(inoutBillEntity.getId());
                inoutBillLineEntity.setSourceOrderLineId(transferBillLineEntity.getId());
                inoutBillLineEntity.setProductId(transferBillLineEntity.getProductId());
                if(code.contains("OUT")){
                    inoutBillLineEntity.setQty(transferBillLineEntity.getOrderQty()*-1);
                    inoutBillLineEntity.setRealQty(isAutoAction(transferBillEntity.get("isAuto"))?inoutBillLineEntity.getQty():0);
                }else{
                    inoutBillLineEntity.setQty(transferBillLineEntity.getOrderQty());
                    inoutBillLineEntity.setRealQty(isAutoAction(transferBillEntity.get("isAuto"))?inoutBillLineEntity.getQty():0);
                }
                inoutBillLineEntity.put("orderQty",inoutBillLineEntity.getRealQty());
                inoutBillLineEntity.setStatus(isAutoAction(transferBillEntity.get("isAuto"))?OrderEnum.COMPLETED.getvalue():OrderEnum.NEW.getvalue());
                inoutBillLineService.save(inoutBillLineEntity);
                inoutBillLineEntityList.add(inoutBillLineEntity);
            }
            if (isAutoAction(transferBillEntity.get("isAuto"))){
                inoutBillEntity.setLineList(inoutBillLineEntityList);
                transactionsService.add(inoutBillEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("拣货失败！"+e.getMessage());
        }
    }

    @Override
    public void saveInoutBill(InoutBillEntity inoutBillEntity) throws RuntimeException {
        try {
            InoutBillEntity newInoutBillEntity=this.getById(inoutBillEntity.getId());
            if(!newInoutBillEntity.getStatus().equals(OrderEnum.NEW.getvalue())){
                throw new RuntimeException("必须草稿状态才能操作！");
            }
            if(inoutBillLineService.isActioned(inoutBillEntity.getId())){
                newInoutBillEntity.setStatus(OrderEnum.COMPLETED.getvalue());
            }
            newInoutBillEntity.setPic(ShiroUtils.getUserEntity().getUsername());
            newInoutBillEntity.setInDate(new Date());
            save(newInoutBillEntity);
            updateSourceOrder(inoutBillEntity);
            inoutBillLineService.updateSourceLine(inoutBillEntity.getSourceOrderId(), BasicEnum.getBasicEnumByCode(inoutBillEntity.getTransactionType()));
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 修改来源单据
     * @param inoutBillEntity
     * @throws RuntimeException
     */
    private void updateSourceOrder(InoutBillEntity inoutBillEntity)throws RuntimeException {
        try {
            if(isActioned(inoutBillEntity)){
                switch (BasicEnum.getBasicEnumByCode(inoutBillEntity.getTransactionType())){
                    case PO_IN:
                    case PO_RETURN_OUT: {
                        PoHeaderEntity poHeaderEntity=poHeaderService.getById(inoutBillEntity.getSourceOrderId());
                        poHeaderEntity.setStatus(OrderEnum.COMPLETED.getvalue());
                        poHeaderService.save(poHeaderEntity);
                    }
                    break;
                    case DB_IN:
                    case DB_OUT:{
                        TransferBillEntity transferBillEntity=transferBillService.getById(inoutBillEntity.getSourceOrderId());
                        transferBillEntity.setStatus(OrderEnum.COMPLETED.getvalue());
                        transferBillService.save(transferBillEntity);
                    }
                    break;
                    case SO_OUT:
                    case SO_RETURN_IN:{
                        SalesOrderEntity salesOrderEntity=salesOrderService.getById(inoutBillEntity.getSourceOrderId());
                        salesOrderEntity.setStatus(OrderEnum.COMPLETED.getvalue());
                        salesOrderService.save(salesOrderEntity);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改来源订单头失败！"+e.getMessage());
        }
    }
    private boolean isActioned(InoutBillEntity inoutBillEntity) {
        boolean result=true;
        Integer actionNum=baseMapper.isActioned(inoutBillEntity.getSourceOrderId(),inoutBillEntity.getSourceOrderType());
        if(actionNum.intValue()>0){
            result=false;
        }
        return result;
    }

    @Override
    public void rollbackInoutBill(Integer sourceId, BasicEnum basicEnum) throws RuntimeException {
        try {
            boolean result=inoutBillLineService.isExistAction(sourceId,basicEnum);
            if(result){
                baseMapper.rollbackInoutBill(sourceId,basicEnum.getAttr());
            }
            else {
                throw new RuntimeException("单据已拣货，不能再回滚！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("回滚拣货单失败！"+e.getMessage());
        }
    }

    @Override
    public List<InoutBillLineEntity> rollbackInoutBillByPoAndPoReturn(Integer sourceId, BasicEnum basicEnum) throws RuntimeException {
        try {
            List<InoutBillLineEntity> inoutBillLineEntityList=inoutBillLineService.getRollAction(sourceId,basicEnum);
            if(inoutBillLineEntityList!=null && inoutBillLineEntityList.size()>0){
                poLineService.rollSourceLine(inoutBillLineEntityList);
                baseMapper.rollbackInoutBillByPoAndPoReturn(inoutBillLineEntityList);
                return inoutBillLineEntityList;
            }
            else {
                throw new RuntimeException("单据已拣货，不能再回滚！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("回滚拣货单失败！"+e.getMessage());
        }
    }

    @Override
    public DefaultBaseModel autoCreate(Object objectClass, BasicEnum basicEnum) throws RuntimeException {
        try {
            IBaseModel iBaseModel=(IBaseModel)objectClass;
            InoutBillEntity inoutBillEntity=new InoutBillEntity();
            inoutBillEntity.setTransactionType(basicEnum.getValue());
            inoutBillEntity.setSourceOrderType(basicEnum.getAttr());
            inoutBillEntity.setSourceOrderId((int)iBaseModel.get("id"));
            inoutBillEntity.setSourceOrderNum(iBaseModel.get("orderNum").toString());
            if(isAutoActionByClass(iBaseModel)){
                inoutBillEntity.setStatus(OrderEnum.COMPLETED.getvalue());
                inoutBillEntity.setInDate(new Date());
            }else{
                inoutBillEntity.setStatus(OrderEnum.NEW.getvalue());
            }
            inoutBillEntity.setWarehouseId((int)iBaseModel.get("warehouseId"));
            inoutBillEntity.setCompanyId((int)iBaseModel.get("companyId"));
            inoutBillEntity.setPic(ShiroUtils.getUserEntity().getUsername());
            inoutBillEntity.setDeletedFlag("N");
            this.save(inoutBillEntity);
            List<Object> objLineList=((List)iBaseModel.get("lineList"));
            List<InoutBillLineEntity> inoutBillLineEntityList=new ArrayList<InoutBillLineEntity>();
            for (Object objLine : objLineList) {
                IBaseModel iBaseModelLine=(IBaseModel)objLine;
                InoutBillLineEntity inoutBillLineEntity=new InoutBillLineEntity();
                inoutBillLineEntity.setBillId(inoutBillEntity.getId());
                inoutBillLineEntity.setSourceOrderLineId((int)iBaseModelLine.get("id"));
                inoutBillLineEntity.setProductId((int)iBaseModelLine.get("productId"));
                if(!StringUtils.isEmpty(iBaseModelLine.get("acceptQty"))){
                    inoutBillLineEntity.setQty(Integer.parseInt(iBaseModelLine.get("acceptQty").toString()));
                }else{
                    inoutBillLineEntity.setQty(Integer.parseInt(iBaseModelLine.get("orderQty").toString()));
                }
                inoutBillLineEntity.setRealQty(isAutoActionByClass(iBaseModel)?inoutBillLineEntity.getQty():0);
                inoutBillLineEntity.put("orderQty",inoutBillLineEntity.getRealQty());
                if(!StringUtils.isEmpty(iBaseModelLine.get("uom"))) {
                    inoutBillLineEntity.setUom(iBaseModelLine.get("uom").toString());
                }
                if(!StringUtils.isEmpty(iBaseModelLine.get("costPrice"))){
                    inoutBillLineEntity.setCostPrice(new BigDecimal(iBaseModelLine.get("costPrice").toString()));
                }
                if(!StringUtils.isEmpty(iBaseModelLine.get("salePrice"))){
                    inoutBillLineEntity.setSalePrice(new BigDecimal(iBaseModelLine.get("salePrice").toString()));
                }
                if(!StringUtils.isEmpty(iBaseModelLine.get("freight"))) {
                    inoutBillLineEntity.setFreight(new BigDecimal(iBaseModelLine.get("freight").toString()));
                }
                inoutBillLineEntity.setStatus(isAutoActionByClass(iBaseModel)?OrderEnum.COMPLETED.getvalue():OrderEnum.NEW.getvalue());
                inoutBillLineService.save(inoutBillLineEntity);
                inoutBillLineEntityList.add(inoutBillLineEntity);
            }
            if (isAutoActionByClass(iBaseModel)){
                inoutBillEntity.setLineList(inoutBillLineEntityList);
                transactionsService.add(inoutBillEntity);
            }
            return inoutBillLineService.getCurrentData(inoutBillEntity.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("拣货失败！"+e.getMessage());
        }
    }

    /**
     * 判断是否自动拣货
     * @param isAuto
     * @return
     */
    public boolean isAutoAction(Object isAuto){
        boolean result=false;
        if (!StringUtils.isEmpty(isAuto) && (boolean) isAuto){
            result=true;
        }
        return result;
    }

    /**
     * 判断是否自动拣货
     * @param classObj
     * @return
     */
    public boolean isAutoActionByClass(IBaseModel classObj){
        boolean result=false;
        if (!StringUtils.isEmpty(classObj.get("isAuto")) &&
                (boolean) classObj.get("isAuto")){
            result=true;
        }
        return result;
    }
}