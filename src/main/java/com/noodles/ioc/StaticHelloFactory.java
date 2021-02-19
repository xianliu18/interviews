package com.noodles.ioc;

import com.noodles.ioc.service.Hello;

/**
 * @ClassName StaticHelloFactory
 * @Description factory-method示例
 * 参考链接： www.tianxiaobo.com/2018/05/30/Spring-IOC-容器源码分析系列文章导读/
 * @Author noodles
 * @Date 2021/2/19 10:09
 */
public class StaticHelloFactory {

    public static Hello getHello() {
        Hello hello = new Hello();
        hello.setContent("created by StaticHelloFactory");
        return hello;
    }

}
