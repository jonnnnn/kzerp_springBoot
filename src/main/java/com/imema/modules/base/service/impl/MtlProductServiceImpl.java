package com.imema.modules.base.service.impl;
/*
 * @author Mr.Lee
 * @time 2019/8/2  1:07
 * */


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MtlProductDao;
import com.imema.modules.base.entity.MtlProduct;
import com.imema.modules.base.service.MtlProductService;
import com.imema.modules.so.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mtlProductService")
public class MtlProductServiceImpl extends BaseServiceImpl<MtlProductDao,MtlProduct> implements MtlProductService {

    @Autowired
    public SalesOrderService salesOrderService;

    @Override
    public PageUtils getList(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);

        dataForm.put("companyId", ShiroUtils.getCompanyId());
        IPage<MtlProduct> page = baseMapper.selectByMapOpsLike(new Query<MtlProduct>().getPage(pageForm), dataForm);
        return new PageUtils(page);
    }

    @Override
    public List<MtlProduct> searchProduct(Map<String,Object> map){
        //处理参数
        String nameStr = (String)map.get("name");
        if (org.springframework.util.StringUtils.isEmpty(nameStr) && map.containsKey("dataForm")) {
            Map<String, Object> dataForm = (Map<String, Object>) map.get("dataForm");
            Map<String, Object> selectFrom = (Map<String, Object>) dataForm.get("data");
            nameStr = selectFrom.get("name")+"";
            map = selectFrom;
        }

        map.put("qureyStr",getParamStr(nameStr));
        if(map.get("companyId")==null)map.put("companyId",ShiroUtils.getCompanyId());
        List<MtlProduct> productList =this.baseMapper.getProduct(map);

        //判断是否需要取上次价
        if(map.containsKey("lastPrice") && objIsNotBlank(map.get("lastPrice"))
                && map.containsKey("customerId") && objIsNotBlank(map.get("customerId"))){
            salesOrderService.setCustLastPrice((Integer)map.get("customerId"),productList);
        }

        return productList;
    }

    @Override
    public String searchProductIds(String nameStr) {
        //处理参数
        String qureyStr = getParamStr(nameStr);
        return baseMapper.getProductIds(qureyStr);
    }

    @Override
    public Integer checkCode(Map<String, Object> params) {
        params.put("companyId", ShiroUtils.getCompanyId());
        return baseMapper.validateCode(params);
    }

    private String getParamStr(String nameStr){
        if(objIsNotBlank(nameStr)){
            nameStr = nameStr.replace(" "," ");
            String [] names = nameStr.split(" ");
            String qureyStr ="";
            for (String name:names) {
                qureyStr += " +\""+name+"\"";
            }
            return qureyStr;
        }
        return null;
    }
}
