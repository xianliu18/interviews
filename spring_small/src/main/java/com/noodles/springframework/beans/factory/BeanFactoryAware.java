package com.noodles.springframework.beans.factory;

import com.noodles.springframework.beans.BeansException;

/**
 * @description: 实现此接口，可以感知到所属的 BeanFactory
 * @author: liuxian
 * @date: 2022-11-12 21:55
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
