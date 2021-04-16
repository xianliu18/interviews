package com.noodles.demo.proxy;

import com.noodles.demo.dao.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: 代理类S
 *      参考链接： https://bugstack.cn/itstack-demo-any/2020/01/20/源码分析-手写mybait-spring核心功能(干货好文一次学会工厂bean-类代理-bean注册的使用).html
 * @Author: noodles
 * @create: 2021-01-25 20:24
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy, method, args) -> "你被代理了" + method.getName();

        return (IUserDao) Proxy.newProxyInstance(classLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }
}
