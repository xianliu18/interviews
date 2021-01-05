package com.noodles.netty.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: 读取自定义XML配置测试类
 * @Author: noodles
 * @create: 2021-01-05 08:44
 */
public class RpcXmlTest {
    public static void main(String[] args) {
        String[] configs = {"rpc-center.xml", "rpc-consumer.xml", "rpc-provider.xml"};
        new ClassPathXmlApplicationContext(configs);
    }
}
