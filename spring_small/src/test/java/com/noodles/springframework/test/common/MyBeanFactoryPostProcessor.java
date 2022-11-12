package com.noodles.springframework.test.common;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.PropertyValue;
import com.noodles.springframework.beans.PropertyValues;
import com.noodles.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import com.noodles.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @description: 自定义 BeanFactoryPostProcesser
 * @author: liuxian
 * @date: 2022-11-12 15:38
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "峡谷一日游"));
    }
}
