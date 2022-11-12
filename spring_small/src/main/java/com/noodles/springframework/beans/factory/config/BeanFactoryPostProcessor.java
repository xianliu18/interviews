package com.noodles.springframework.beans.factory.config;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @description: 允许自定义修改 BeanDefinition 属性信息
 * @author: liuxian
 * @date: 2022-11-12 15:38
 */
public interface BeanFactoryPostProcessor {
    
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
