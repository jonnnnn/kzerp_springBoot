package com.imema.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imema.common.utils.PageUtils;
import com.imema.core.BaseServiceImpl;
import com.imema.modules.sys.dao.SysDictionaryDao;
import com.imema.modules.sys.entity.SysDictionaryEntity;
import com.imema.modules.sys.service.SysDictionaryService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Mr.Lee
 * @since 2019-09-02 15:30
 * Description:
 **/
@Service("sysDictionaryService")
public class SysDictionaryServiceImpl extends BaseServiceImpl<SysDictionaryDao,SysDictionaryEntity>
        implements SysDictionaryService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
}
