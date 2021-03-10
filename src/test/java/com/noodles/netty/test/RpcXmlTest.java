package com.noodles.netty.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description: 读取自定义XML配置测试类
 * @Author: noodles
 * @create: 2021-01-05 08:44
 */
public class RpcXmlTest {
    public static void main(String[] args) {
        String[] configs = {"src/test/resources/rpc-center.xml", "src/test/resources/rpc-consumer.xml", "src/test/resources/rpc-provider.xml"};
        new FileSystemXmlApplicationContext(configs);
    }
}
