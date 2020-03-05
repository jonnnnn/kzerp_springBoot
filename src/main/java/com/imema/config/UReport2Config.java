/*
 * Copyright (c) 2018-2019 广州盟码信息科技有限公司 All rights reserved.
 */

package com.imema.config;


import com.bstek.ureport.provider.report.file.FileReportProvider;
import com.imema.common.utils.CommonStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties(prefix = "ureport")
@ImportResource(locations= {"classpath:ureport-console-context.xml"})
public class UReport2Config {

    private String fileStoreDir;

    private final static String CLASSPATH_PREFIX = "classpath:";

    @Autowired
    private FileReportProvider fileReportProvider;

    @PostConstruct
    public void initUReport() throws Exception {
        if(!CommonStringUtils.isEmpty(fileStoreDir) && fileStoreDir.startsWith(CLASSPATH_PREFIX)) {
            fileStoreDir = fileStoreDir.replace(CLASSPATH_PREFIX, "");
            if(fileStoreDir.startsWith("/")) {
                fileStoreDir = fileStoreDir.substring(1);
            }
            /*fileStoreDir = ResourceUtils.getURL(CLASSPATH_PREFIX).getPath() + fileStoreDir;*/
        }
        fileReportProvider.setFileStoreDir(fileStoreDir);
    }

    public void setFileStoreDir(String fileStoreDir) {
        this.fileStoreDir = fileStoreDir;
    }

    public String getFileStoreDir() {
        return fileStoreDir;
    }
}