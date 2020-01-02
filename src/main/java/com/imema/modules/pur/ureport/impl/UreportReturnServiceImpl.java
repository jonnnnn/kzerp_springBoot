package com.imema.modules.pur.ureport.impl;

import com.imema.core.BaseServiceImpl;
import com.imema.modules.pur.dao.PoLineDao;
import com.imema.modules.pur.entity.PoLineEntity;
import com.imema.modules.pur.ureport.UreportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-10-16 17:18
 * Description:订单退货
 **/
@Service("ureportReturnService")
public class UreportReturnServiceImpl  extends BaseServiceImpl<PoLineDao, PoLineEntity> implements UreportService {
    @Override
    public List<Map<String,Object>> buildReport(String dsName, String datasetName, Map<String,Object> param){
//        param.put("companyId", ShiroUtils.getCompanyId());
        param.put("orderType","PO_RETURN");

        return baseMapper.getList(param);
    }
}
