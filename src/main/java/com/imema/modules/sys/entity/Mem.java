package com.imema.modules.sys.entity;

import lombok.Data;

/**
 * @author Mr.Lee
 * @since 2019-10-21 10:59
 * Description: 内存信息
 **/
@Data
public class Mem {

    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;
}
