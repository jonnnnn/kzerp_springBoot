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
 * @since 2019-10-16 11:49
 * Description: 报表输出
 **/
@Service("ureportService")
public class UreportServiceImpl extends BaseServiceImpl<PoLineDao, PoLineEntity> implements UreportService {

    @Override
    public List<Map<String,Object>> buildReport(String dsName,String datasetName,Map<String,Object> param){
        param.put("orderType","PO_ORDER");

        List list = baseMapper.getList(param);
        log.debug(list.get(0).toString());
        return baseMapper.getList(param);
    }

}
