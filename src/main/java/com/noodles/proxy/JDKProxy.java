package com.noodles.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxy
 * @Description JDK代理
 *      参考链接： https://bugstack.cn/interview/2020/10/14/面经手册-第13篇-除了JDK-CGLIB-还有3种类代理方式-面试又卡住.html
 * @Author noodles
 * @Date 2021/1/18 19:09
 */
public class JDKProxy {
    public static <T> T getProxy(Class clazz) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "被 JDK 代理了~~~");
                return "天气晴朗，万里无云 from JDK";
            }
        });
    }
}
