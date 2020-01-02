/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.inv.controller;

import com.imema.common.enums.EntityState;
import com.imema.common.utils.BillnumHelper;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.modules.app.annotation.LoginUser;
import com.imema.modules.common.BasicEnum;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.inv.entity.TransferBillEntity;
import com.imema.modules.inv.entity.TransferBillLineEntity;
import com.imema.modules.inv.service.InoutBillService;
import com.imema.modules.inv.service.TransferBillLineService;
import com.imema.modules.inv.service.TransferBillService;
import com.imema.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 * 调拨单
 *
 * @author xck
 * @email 522269416@qq.com
 * @date 2019-07-25 17:06:39
 */
@RestController
@RequestMapping("inv/transferbill")
@Api("APP调拨接口")
public class TransferBillController {
    @Autowired
    private TransferBillService transferBillService;
    @Autowired
    private TransferBillLineService transferBillLineService;
    @Autowired
    private InoutBillService inoutBillService;
    @Autowired
    private BillnumHelper billnumHelper;

    /**
     * 列表
     */
    @PostMapping("/list")
    @ApiOperation("获取调拨列表")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = transferBillService.queryPage(params);
        return R.ok().putData(page);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("inv:transferbill:save")
    @ApiOperation("调拨保存")
    @Transactional
    public R save(@RequestBody TransferBillEntity transferBillEntity){
        try {
            EntityState state = transferBillEntity.getState();
            if (state.equals(EntityState.NEW)) {
                transferBillEntity.setTransferDate(new Date());
                transferBillEntity.setStatus(OrderEnum.NEW.getvalue());
                transferBillEntity.setDeletedFlag("N");
                transferBillEntity.setOutCompanyId(ShiroUtils.getCompanyId());
                transferBillEntity.setInCompanyId(ShiroUtils.getCompanyId());
                transferBillService.save(transferBillEntity);
                // 保存从表数据
                transferBillLineService.save(transferBillEntity);
            } else if (state.equals(EntityState.MODIFIED)) {
                transferBillService.save(transferBillEntity);
                transferBillLineService.save(transferBillEntity);
            } else if (state.equals(EntityState.DELETED)) {
                transferBillEntity.setDeletedFlag("Y");
                transferBillService.save(transferBillEntity);
            } else if (state.equals(EntityState.NONE)) {
                transferBillLineService.save(transferBillEntity);
            }
        } catch (Exception e) {
            throw new RuntimeException("保存订单失败！"+e.getMessage());
        }
        return R.ok();
    }
    /**
     * 提交并且自动拣货
     */
    @PostMapping("/submit")
    @RequiresPermissions("inv:transferbill:submit")
    @ApiOperation("调拨提交")
    @Transactional
    public R submit(@RequestBody TransferBillEntity transferBillEntity)throws Exception{
        try {
            Boolean isAuto=(Boolean)transferBillEntity.get("isAuto");
            transferBillEntity=transferBillService.getById(transferBillEntity.getId());
            if(!transferBillEntity.getStatus().equals(OrderEnum.NEW.getvalue())){
                throw new RuntimeException("必须草稿状态才能操作！");
            }
            List<TransferBillLineEntity> transferBillLineEntityList=transferBillLineService.getTransferBillLineEntityListByTransferBillId(transferBillEntity.getId());
            if(transferBillLineEntityList==null || transferBillLineEntityList.size()==0){
                throw new RuntimeException("单据明细不能为空！");
            }
            transferBillEntity.setLineList(transferBillLineEntityList);
            transferBillEntity.put("isAuto",isAuto);
            if(isAuto){
                transferBillEntity.setStatus(OrderEnum.COMPLETED.getvalue());
            }else{
                transferBillEntity.setStatus(OrderEnum.SENDED.getvalue());
            }
            inoutBillService.createActionByTransferBill(transferBillEntity, BasicEnum.DB_OUT);
            inoutBillService.createActionByTransferBill(transferBillEntity, BasicEnum.DB_IN);
            transferBillService.save(transferBillEntity);
        } catch (Exception e) {
            throw new RuntimeException("提交订单失败！"+e.getMessage());
        }
        return R.ok();
    }
    /**
     * 回滚
     */
    @RequestMapping("/rollback")
    @RequiresPermissions("inv:transferbill:rollback")
    @ApiOperation("调拨回滚")
    @Transactional
    public R rollback(Integer sourceId){
        try {
            TransferBillEntity transferBillEntity=transferBillService.getById(sourceId);
            if(!transferBillEntity.getStatus().equals(OrderEnum.SENDED.getvalue())){
                throw new RuntimeException("必须已生成拣货指令状态才能操作！");
            }
            inoutBillService.rollbackInoutBill(sourceId,BasicEnum.DB_OUT);
            transferBillEntity.setStatus(OrderEnum.NEW.getvalue());
            transferBillService.save(transferBillEntity);
        } catch (Exception e) {
            throw new RuntimeException("回滚订单失败！"+e.getMessage());
        }
        return R.ok();
    }
}
