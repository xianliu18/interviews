package com.noodles.springframework.beans.factory.support;

import com.noodles.springframework.beans.BeansException;
import com.noodles.springframework.beans.factory.config.BeanDefinition;

/**
 * @description: BeanDefinition 注册接口
 * @author: liuxian
 * @date: 2022-11-11 15:46
 */
public interface BeanDefinitionRegistry {
    
    /*
     * 向注册表中注册 BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
      * 使用 Bean 名称查询 BeanDefinition
      */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的 BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的 Bean 名称
     */
    String[] getBeanDefinitionNames();
    
}
