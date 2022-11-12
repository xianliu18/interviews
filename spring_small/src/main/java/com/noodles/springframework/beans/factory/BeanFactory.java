package com.noodles.springframework.beans.factory;

import com.noodles.springframework.beans.BeansException;

/**
 * @description: getBean 方法
 * @author: liuxian
 * @date: 2022-11-11 15:44
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
