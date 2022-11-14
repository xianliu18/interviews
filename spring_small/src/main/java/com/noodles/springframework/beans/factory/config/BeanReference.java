package com.noodles.springframework.beans.factory.config;

/**
 * @description: BeanReference
 * @author: liuxian
 * @date: 2022-11-11 17:27
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
