package com.noodles.springframework.beans.factory;

/**
 * @description: FactoryBean
 * @author: liuxian
 * @date: 2022-11-12 22:44
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
