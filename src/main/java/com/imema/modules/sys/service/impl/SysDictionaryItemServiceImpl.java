package com.imema.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.common.utils.Query;
import com.imema.common.utils.R;
import com.imema.common.utils.ShiroUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.sys.dao.SysDictionaryItemDao;
import com.imema.modules.sys.entity.SysDictionaryItemEntity;
import com.imema.modules.sys.service.SysDictionaryItemService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-09-02 15:28
 * Description:
 **/
@Service("sysDictionaryItemService")
public class SysDictionaryItemServiceImpl extends
        BaseServiceImpl<SysDictionaryItemDao,SysDictionaryItemEntity> implements SysDictionaryItemService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Map<String, Object> pageForm = (Map<String, Object>) params.get("pageForm");
        Map<String, Object> dataForm = R.extractParams(params);
        Integer companyId= ShiroUtils.getCompanyId();
        dataForm.put("companyId",companyId);

        IPage<SysDictionaryItemEntity> page=baseMapper
                .queryPage(new Query<SysDictionaryItemEntity>().getPage(pageForm),dataForm);
        return new PageUtils(page);
    }

    @Override
    public Integer checkCode(Map<String, Object> params) {
        return baseMapper.checkCode(params);
    }
}
