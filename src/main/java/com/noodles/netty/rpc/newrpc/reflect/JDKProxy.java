package com.noodles.netty.rpc.newrpc.reflect;

import com.noodles.netty.rpc.newrpc.network.msg.Request;
import com.noodles.netty.rpc.newrpc.util.ClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName JDKProxy
 * @Description JDK 代理类
 * @Author noodles
 * @Date 2021/1/5 17:03
 */
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass, Request request) {
        InvocationHandler handler = new JDKInvocationHandler(request);
        ClassLoader classLoader = ClassLoaderUtils.getCurrentClassLoader();
        T result = (T) Proxy.newProxyInstance(classLoader, new Class[]{interfaceClass}, handler);
        return result;
    }
}
