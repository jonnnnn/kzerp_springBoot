package com.imema.modules.sys.controller;

import com.imema.common.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Lee
 * @since 2019-10-21 11:23
 * Description: 首页数据大纲
 **/
@RestController
@RequestMapping("/home/sum")
public class HomeController {

    /**
     * 销售概况
     * */
    @RequestMapping("/sale")
    public R salInfo(){
        return R.ok().putData("");
    }

    /**
     * 销售历史统计
     * */
    @RequestMapping("/history")
    public R salHistory(){
        return R.ok().putData("");
    }

    /**
     * 产品销售排行
     * */
    @RequestMapping("/rank")
    public R salRank(){
        return R.ok().putData("");
    }

    /**
     * 下单率统计
     * */
    @RequestMapping("/tran")
    public R salTrans(){
        return R.ok().putData("");
    }
}
