/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.config;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    //注册Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new UReportServlet(), "/ureport/*");
    }

}
