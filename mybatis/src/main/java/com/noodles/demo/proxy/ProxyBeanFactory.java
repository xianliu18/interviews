package com.noodles.demo.proxy;

import com.noodles.demo.dao.IUserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: 代理类S
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
