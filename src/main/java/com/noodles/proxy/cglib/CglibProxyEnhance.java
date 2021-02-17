package com.noodles.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 增强类
 * @Author: noodles
 * @create: 2021-02-17 22:33
 */
@Slf4j
public class CglibProxyEnhance {

    public void selectUser() {
        log.info("添加用户之前查询是否有该用户_______Cglib动态代理增强");
    }

    public void addLog() {
        log.info("添加用户之后, 新增日志记录______Cglib动态代理增强");
    }

}
