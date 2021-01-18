package com.noodles.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description CGLIB 代理方式
 * @Author noodles
 * @Date 2021/1/18 19:14
 */
public class CglibProxy implements MethodInterceptor {

    public Object newInstall(Object object) {
        return Enhancer.create(object.getClass(), this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB Proxy 代理……");
        return methodProxy.invokeSuper(o, objects);
    }
}
