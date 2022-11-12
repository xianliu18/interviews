package com.noodles.springframework.beans.factory.config;

import com.noodles.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @description: 可配置 Bean 工厂接口
 * @author: liuxian
 * @date: 2022-11-11 18:21
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
