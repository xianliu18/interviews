package com.noodles.springframework.beans.factory.support;

import com.noodles.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 默认实现
 * @author: liuxian
 * @date: 2022-11-11 15:46
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
