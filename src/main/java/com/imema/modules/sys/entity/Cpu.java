package com.imema.modules.sys.entity;

import lombok.Data;

/**
 * @author Mr.Lee
 * @since 2019-10-21 10:58
 * Description:
 **/
@Data
public class Cpu {
    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总的使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CPU当前空闲率
     */
    private double free;
}
