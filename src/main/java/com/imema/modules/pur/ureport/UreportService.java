package com.imema.modules.pur.ureport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imema.modules.pur.entity.PoLineEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-10-16 12:29
 * Description:
 **/
public interface UreportService  extends IService<PoLineEntity> {
    List<Map<String,Object>> buildReport(String dsName,String datasetName,Map<String, Object> param);
}
