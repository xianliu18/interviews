package com.noodles.springframework.test.bean;

import com.noodles.springframework.beans.factory.FactoryBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 代理 FactoryBean
 * @author: liuxian
 * @date: 2022-11-12 23:38
 */
public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "王者");
            hashMap.put("10002", "瓜保熟");
            hashMap.put("10003", "luke");

            return "你被代理了 " + method.getName() + ":" + hashMap.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
