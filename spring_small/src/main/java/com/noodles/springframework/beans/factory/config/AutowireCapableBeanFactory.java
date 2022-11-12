package com.noodles.springframework.beans.factory.config;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.BeanFactory;

/**
 * @description: 可自动装配的 BeanFactory 接口
 * @author: liuxian
 * @date: 2022-11-11 18:21
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     */
    Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization 方法
     */
    Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
