package com.noodles.springframework.beans.factory;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import com.noodles.springframework.beans.factory.config.BeanPostProcessor;
import com.noodles.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @description: 可自动配置的 bean 工厂接口
 * @author: liuxian
 * @date: 2022-11-11 18:23
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
