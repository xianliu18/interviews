package com.noodles.demo.like.spring;

import com.noodles.demo.like.mybatis.SqlSession;
import com.noodles.demo.like.mybatis.SqlSessionFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description:
 * @Author:
 * @create: 2021-01-24 22:17
 */
public class MapperFactoryBean<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;
    private SqlSessionFactory sqlSessionFactory;

    public MapperFactoryBean(Class<T> mapperInterface, SqlSessionFactory sqlSessionFactory) {
        this.mapperInterface = mapperInterface;
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            System.out.println("你被代理了,执行SQL操作!" + method.getName());
            try {
                SqlSession session = sqlSessionFactory.openSession();
                try {
                    return session.selectOne(mapperInterface.getName() + "." + method.getName(), args[0]);
                } finally {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return method.getReturnType().newInstance();
        };

        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{mapperInterface}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
