package com.noodles.proxy.cglib;

/**
 * @Description: 测试类
 * @Author: noodles
 * @create: 2021-02-17 22:42
 */
public class CglibProxyMain {
    public static void main(String[] args) {
        CglibProxyImpl impl = new CglibProxyImpl();
        CglibProxyEnhance enhance = new CglibProxyEnhance();
        CglibProxyFactory factory = new CglibProxyFactory();
        CglibProxyImpl proxy = (CglibProxyImpl)factory.proxy(impl, enhance);
        proxy.addUser("test");
    }
}
