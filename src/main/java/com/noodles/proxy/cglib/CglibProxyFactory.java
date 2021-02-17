package com.noodles.proxy.cglib;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Description: 代理类
 * @Author: noodles
 * @create: 2021-02-17 22:35
 */
public class CglibProxyFactory implements MethodInterceptor {

    // 目标类
    public Object object;

    // 增强类
    public CglibProxyEnhance cglibProxyEnhance;

    public Object proxy(Object object, CglibProxyEnhance cglibProxyEnhance) {
        this.object = object;
        this.cglibProxyEnhance = cglibProxyEnhance;
        // 创建增强器, 用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        // 为增强器指定要代理的业务目标类
        enhancer.setSuperclass(this.object.getClass());
        // 设置回调: 代理类上的所有方法都会调用callback, 而callback需要实现intercept进行拦截
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(objects[0]);
        this.cglibProxyEnhance.selectUser();
        Object invoke = method.invoke(this.object, objects);
        this.cglibProxyEnhance.addLog();
        return invoke;
    }
}
