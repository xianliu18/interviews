package com.noodles.springframework.beans.factory;


import com.noodles.springframework.beans.BeansException;
import java.util.Map;

/**
 * @description: TODO
 * @author: liuxian
 * @date: 2022-11-11 18:24
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的 bean 名称
     */
    String[] getBeanDefinitionNames();

}
