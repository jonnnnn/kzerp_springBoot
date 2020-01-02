package com.imema.modules.base.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imema.common.utils.*;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.base.dao.MtlProductPriceDao;
import com.imema.modules.base.entity.MtlProductMadein;
import com.imema.modules.base.entity.MtlProductPrice;
import com.imema.modules.base.service.MtlProductPriceService;
import com.imema.modules.form.FormParams;
import com.imema.modules.inv.entity.OnhandEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-08-12 10:09
 * Description:
 **/
@Service("mtlProductPriceService")
public class MtlProductPriceServiceImpl extends BaseServiceImpl<MtlProductPriceDao, MtlProductPrice> implements MtlProductPriceService {
    @Override
    public PageUtils getList(Map<String,Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);
        IPage<MtlProductPrice> page=baseMapper.
                selectCode(new Query<MtlProductPrice>().getPage(pageForm),dataForm);
        return new PageUtils(page);
    }

    @Override
    public void addOrUpdate(OnhandEntity onhandEntity) {
        MtlProductPrice mtlProductPrice=this.getProductPrice(onhandEntity);
        if(mtlProductPrice==null){
            mtlProductPrice=new MtlProductPrice();
            mtlProductPrice.setCostPrice(new BigDecimal(onhandEntity.get("avgCostPrice").toString()));
            mtlProductPrice.setProductId(onhandEntity.getProductId());
            this.save(mtlProductPrice);
        }else{
            mtlProductPrice.setCostPrice(new BigDecimal(onhandEntity.get("avgCostPrice").toString()));
            mtlProductPrice.setUpdateBy(ShiroUtils.getUserEntity().getUsername());
            mtlProductPrice.setUpdateDate(new Date());
            this.updateById(mtlProductPrice);
        }
    }

    @Override
    public boolean checkProductId(Map<String, Object> params) {
        int companyId=ShiroUtils.getCompanyId();
        params.put("companyId",companyId);
        return baseMapper.checkProductId(params) > 0;
    }

    public MtlProductPrice getProductPrice(OnhandEntity onhandEntity){
        return baseMapper.getProductPrice(onhandEntity);
    }
}
