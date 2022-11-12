package com.noodles.springframework.beans.factory;

/**
 * @description: BeanClassLoaderAware
 * @author: liuxian
 * @date: 2022-11-12 21:55
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);

}
