package com.noodles.springframework.beans.factory.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * @description: bean 实例化策略
 * @author: liuxian
 * @date: 2022-11-11 16:33
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
