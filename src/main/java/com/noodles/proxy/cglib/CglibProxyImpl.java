package com.noodles.proxy.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 目标类
 * @Author: noodles
 * @create: 2021-02-17 22:32
 */
@Slf4j
public class CglibProxyImpl {

    public void addUser(String s) {
        log.info("添加用户成功_Cglib " + s);
    }

}
