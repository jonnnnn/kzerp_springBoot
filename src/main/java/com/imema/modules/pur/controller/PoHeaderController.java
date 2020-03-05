/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.pur.controller;

import com.imema.common.enums.EntityState;
import com.imema.common.utils.BillnumHelper;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.data.DefaultBaseModel;
import com.imema.modules.app.annotation.LoginUser;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.fin.service.PayrecService;
import com.imema.modules.inv.entity.InoutBillLineEntity;
import com.imema.modules.inv.service.InoutBillLineService;
import com.imema.modules.inv.service.InoutBillService;
import com.imema.modules.pur.entity.PoHeaderEntity;
import com.imema.modules.pur.entity.PoLineEntity;
import com.imema.modules.pur.service.PoHeaderService;
import com.imema.modules.pur.service.PoLineService;
import com.imema.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 采购单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-26 09:33:11
 */
@RestController
@RequestMapping("pur/poheader")
@Api("APP采购接口")
public class PoHeaderController {
    @Autowired
    private PoHeaderService poHeaderService;
    @Autowired
    private PoLineService poLineService;
    @Autowired
    private InoutBillService inoutBillService;
    @Autowired
    private InoutBillLineService inoutBillLineService;
    @Autowired
    private BillnumHelper billnumHelper;
    @Autowired
    private PayrecService payrecService;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取采购列表")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = poHeaderService.queryPage(params);
        return R.ok().putData(page);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("pur:poheader:save")
    @ApiOperation("采购保存")
    @Transactional
    public R save(@RequestBody PoHeaderEntity poHeader){
        try {
            if(poHeader.get("saveType")!=null && poHeader.get("saveType").equals("pick")){
                /*this.submit(poHeader);*/
            }else {
                EntityState state = poHeader.getState();
                System.out.println("***********state:"+state);
                if (state.equals(EntityState.NEW)) {
                    if(poHeader.getOrderType().equals(OrderEnum.PO.getvalue())){
                        poHeader.setOrderNum(billnumHelper.getNextNum("PUR_PO_HEADER"));
                    }else{
                        poHeader.setOrderNum(billnumHelper.getNextNum("PUR_PO_HEADER_RETURN"));
                    }
                    poHeader.setStatus(OrderEnum.NEW.getvalue());
                    poHeader.setOrderDate(new Date());
                    poHeaderService.save(poHeader);
                    // 保存从表数据
                    System.out.println("poHeader:"+poHeader);
                    poLineService.save(poHeader);
                } else if (state.equals(EntityState.MODIFIED)) {
                    poHeaderService.save(poHeader);
                    poLineService.save(poHeader);
                    System.out.println(poHeader);
                   /* System.out.println(poHeader.getLineList().get(0));*/

                } else if (state.equals(EntityState.DELETED)) {
                    System.out.println("run");
                    poHeader.setDeletedFlag("Y");
                    poHeaderService.save(poHeader);
                } else if (state.equals(EntityState.NONE)) {
                    poLineService.save(poHeader);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("保存订单失败！"+e.getMessage());
        }
        return R.ok();
    }
    /**
     * 提交
     */
    @PostMapping("/posubmit")
    @RequiresPermissions("pur:poheader:submit")
    @ApiOperation("采购提交")
    @Transactional
    public R poSubmit(@RequestBody PoHeaderEntity poHeader){
        try {
            poHeader=poHeaderService.getById(poHeader.getId());
            if(!poHeader.getStatus().equals(OrderEnum.NEW.getvalue())){
                throw new RuntimeException("必须草稿状态才能操作！");
            }
            poHeader.setStatus(OrderEnum.SUBMIT.getvalue());
            poHeaderService.save(poHeader);
        } catch (Exception e) {
            throw new RuntimeException("提交订单失败！"+e.getMessage());
        }
        return R.ok();
    }
    /**
     * 提交并且自动入库
     */
    /*public void submit(PoHeaderEntity poHeader) throws RuntimeException{
        try {
            PoHeaderEntity po=poHeaderService.getById(poHeader.getId());
            if(!po.getStatus().equals(OrderEnum.SUBMIT.getvalue()) && !po.getStatus().equals(OrderEnum.SENDED.getvalue())){
                throw new RuntimeException("必须已提交或者已拣货状态才能操作！");
            }
            float freight=0f;
            if(poHeader.get("freight")!=null){
                freight=Float.parseFloat(poHeader.get("freight").toString());
            }
            if(poHeader.getOrderType().equals(OrderEnum.PO.getvalue())){
                poHeader.setTotalFreight(poHeader.getTotalFreight().add(new BigDecimal(freight)));
            }else {
                poHeader.setTotalFreight(poHeader.getTotalFreight().add(new BigDecimal(Math.abs(freight)*-1)));
            }
            poLineService.saveFreight(poHeader);
            if(poLineService.isRkLast(poHeader.getId())){
                poHeader.setStatus(OrderEnum.COMPLETED.getvalue());
            }else{
                poHeader.setStatus(OrderEnum.SENDED.getvalue());
            }
            poHeaderService.save(poHeader);
            if(poHeader.getOrderType().equals(OrderEnum.PO.getvalue())){
                DefaultBaseModel map=inoutBillService.autoCreate(poHeader, BasicEnum.PO_IN);
                if(poHeader.get("freight")!=null)poHeader.put("freight",new BigDecimal(freight));
                poHeader.put("pickId",map.get("pickId"));
                poHeader.put("currentAmount",map.get("currentAmount"));
                payrecService.createrPayrec(poHeader, OrderEnum.PO);
            }else {
                DefaultBaseModel map=inoutBillService.autoCreate(poHeader, BasicEnum.PO_RETURN_OUT);
                if(poHeader.get("freight")!=null)poHeader.put("freight",new BigDecimal(Math.abs(freight)*-1));
                poHeader.put("pickId",map.get("pickId"));
                poHeader.put("currentAmount",map.get("currentAmount"));
                payrecService.createrPayrec(poHeader, OrderEnum.PO_RETURN);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }*/
    /**
     * 回滚
     */
    @RequestMapping("/rollback")
    @RequiresPermissions("pur:poheader:rollback")
    @ApiOperation("(采购/采购退货)回滚")
    @Transactional
    public R rollback(Integer sourceId){
        try {
            PoHeaderEntity poHeader=poHeaderService.getById(sourceId);
            if(!poHeader.getStatus().equals(OrderEnum.SENDED.getvalue()) && !poHeader.getStatus().equals(OrderEnum.SUBMIT.getvalue())){
                throw new RuntimeException("必须已提交或者已生成拣货指令状态才能操作！");
            }
            if(poHeader.getStatus().equals(OrderEnum.SENDED.getvalue())){
                if(poHeader.getOrderType().equals(OrderEnum.PO.getvalue())){
                    List<InoutBillLineEntity> inoutBillLineEntityList=inoutBillService.rollbackInoutBillByPoAndPoReturn(sourceId,BasicEnum.PO_IN);
                    if(inoutBillLineService.isExistAction(sourceId,BasicEnum.PO_IN)){
                        poHeader.setStatus(OrderEnum.SUBMIT.getvalue());
                    }
                    List<Integer> billIdList = inoutBillLineEntityList.stream().map(InoutBillLineEntity::getBillId).distinct().collect(Collectors.toList());
                    for (Integer billId : billIdList) {
                        poHeader.put("pickId",billId);
                        payrecService.cancelPayrec(poHeader,OrderEnum.PO);
                    }
                }else {
                    List<InoutBillLineEntity> inoutBillLineEntityList=inoutBillService.rollbackInoutBillByPoAndPoReturn(sourceId,BasicEnum.PO_RETURN_OUT);
                    if(inoutBillLineService.isExistAction(sourceId,BasicEnum.PO_RETURN_OUT)){
                        poHeader.setStatus(OrderEnum.SUBMIT.getvalue());
                    }
                    List<Integer> billIdList = inoutBillLineEntityList.stream().map(InoutBillLineEntity::getBillId).distinct().collect(Collectors.toList());
                    for (Integer billId : billIdList) {
                        poHeader.put("pickId",billId);
                        payrecService.cancelPayrec(poHeader,OrderEnum.PO_RETURN);
                    }
                }
                poHeader.setTotalFreight(poLineService.getOrderTotalFreight(poHeader.getId()));
            }else{
                poHeader.setStatus(OrderEnum.NEW.getvalue());
            }
            poHeaderService.save(poHeader);
        } catch (Exception e) {
            throw new RuntimeException("回滚订单失败！"+e.getMessage());
        }
        return R.ok();
    }
}
