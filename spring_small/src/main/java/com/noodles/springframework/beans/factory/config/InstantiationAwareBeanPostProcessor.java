package com.noodles.springframework.beans.factory.config;

import com.noodles.springframework.beans.BeansException;

/**
 * @description: InstantiationAwareBeanPostProcessor
 * @author: liuxian
 * @date: 2022-11-13 16:45
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

}
