package com.imema.modules.sys.entity;

import lombok.Data;

/**
 * @author Mr.Lee
 * @since 2019-10-21 10:58
 * Description: JVM信息
 **/
@Data
public class Jvm {
    /**
     * 当前JVM占用的内存总数(M)
     */
    private double total;

    /**
     * JVM最大可用内存总数(M)
     */
    private double max;

    /**
     * JVM空闲内存(M)
     */
    private double free;

    /**
     * JDK版本
     */
    private String version;

    /**
     * JDK路径
     */
    private String home;
}
