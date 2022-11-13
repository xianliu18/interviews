package com.noodles.springframework.beans.factory.config;

/**
 * @description: 单例注册表
 * @author: liuxian
 * @date: 2022-11-11 15:43
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
