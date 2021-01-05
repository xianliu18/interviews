package com.noodles.netty.test.service.impl;

import com.noodles.netty.test.service.HelloService;

/**
 * @Description: 实现类
 * @Author: noodles
 * @create: 2021-01-05 08:37
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void echo() {
        System.out.println("hi rpc demo~~~");
    }
}
