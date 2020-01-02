package com.imema.modules.sys.controller;

import com.imema.common.utils.R;
import com.imema.modules.sys.entity.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Lee
 * @since 2019-10-21 11:07
 * Description: 系统信息提供
 **/
@RestController
@RequestMapping("/sys/info")
public class SysInfoController {
    @GetMapping("/server")
    public R server() throws Exception {
        Server server = new Server();
        server.copyTo();
        return R.ok().putData(server);
    }
}
