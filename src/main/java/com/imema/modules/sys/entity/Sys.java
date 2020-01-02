package com.imema.modules.sys.entity;

import lombok.Data;

/**
 * @author Mr.Lee
 * @since 2019-10-21 11:00
 * Description: 系统相关信息
 **/
@Data
public class Sys {
    /**
     * 服务器名称
     */
    private String computerName;

    /**
     * 服务器Ip
     */
    private String computerIp;

    /**
     * 项目路径
     */
    private String userDir;

    /**
     * 操作系统
     */
    private String osName;

    /**
     * 系统架构
     */
    private String osArch;
}
