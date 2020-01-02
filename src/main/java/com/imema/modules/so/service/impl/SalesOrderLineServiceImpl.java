/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.modules.so.service.impl;

import com.imema.common.utils.ShiroUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.common.OrderEnum;
import com.imema.modules.so.dao.SalesOrderLineDao;
import com.imema.modules.so.entity.SalesOrderLineEntity;
import com.imema.modules.so.service.SalesOrderLineService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("salesOrderLineService")
public class SalesOrderLineServiceImpl extends BaseServiceImpl<SalesOrderLineDao, SalesOrderLineEntity> implements SalesOrderLineService {

    @Override
    public List<SalesOrderLineEntity> queryOrder(Map<String, Object> params) {
        Map<String, Object> dataForm = (Map<String, Object>) params.get("dataForm");
        if(dataForm != null && dataForm.containsKey("data")){
            Map<String, Object> selectFrom = (Map<String, Object>) dataForm.get("data");
            if(selectFrom.containsKey("id")){
                List<SalesOrderLineEntity> list =
                        this.baseMapper.getListByOrderId(selectFrom);
                return list;
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> querySummary(Map<String, Object> params) {
        Map<String,Object> result=new HashMap<>();
        Integer companyId= ShiroUtils.getCompanyId();
        params.put("companyId",companyId);
        params.put("status", "("+OrderEnum.CANCEL.getvalue()+")");
        params.put("deletedFlag","N");
        params.put("orderType",OrderEnum.SO.getvalue());
        /**
         * 所有销售
         *
         * s.ORDER_TYPE = 'SO_ORDER'
         *   and s.STATUS != 'CANCEL'
         *   and s.DELETED_FLAG = 'N'
         *   and s.COMPANY_ID = 1;
         * */
        result.put("salSum",baseMapper.querySum(params).get("s1"));

        /**
         * 当日及当月销售额 && 毛利
         * */
        params.put("dateSal","F");
        result.put("salSumDat",baseMapper.querySum(params).get("s1"));
        result.put("salProfitDat",baseMapper.querySum(params).get("s2"));

        params.remove("dateSal");
        params.put("monthSal","F");
        result.put("salSumMon",baseMapper.querySum(params).get("s1"));
        result.put("salProfitMon",baseMapper.querySum(params).get("s2"));

        /**
         * 待发货订单
         *s.ORDER_TYPE = 'SO'
         *   and s.STATUS =''
         *   and s.DELETED_FLAG = 'N'
         *   and COMPANY_ID = 1;
         * */
        params.remove("monthSal");
        params.put("status","("+OrderEnum.NEW.getvalue()+OrderEnum.SUBMIT.getvalue()+")");
        result.put("waitDeliver",baseMapper.querySum(params).get("s3"));

        /**
         * 待退货
         * where s.ORDER_TYPE = 'SO_RETURN'
         *   and s.STATUS != 'CANCEL'
         *   and s.DELETED_FLAG = 'N'
         *   and s.COMPANY_ID = 1;
         * */
        params.put("orderType",OrderEnum.SO_RETURN.getvalue());
        result.put("waitReturn",baseMapper.querySum(params).get("s3"));

        /**
         * 待审批
         *      s.STATUS = 'NEW'
         *   and s.DELETED_FLAG = 'N'
         *   and s.COMPANY_ID = 1;
         * */
        params.remove("orderType");
        params.put("status",OrderEnum.NEW.getvalue());
        result.put("waitPermit",baseMapper.querySum(params).get("s3"));
        return result;
    }


}
