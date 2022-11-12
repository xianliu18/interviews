package com.noodles.springframework.beans.factory;

/**
 * @description: 感知 BeanName
 * @author: liuxian
 * @date: 2022-11-12 21:56
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
