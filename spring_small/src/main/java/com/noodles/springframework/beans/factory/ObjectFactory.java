package com.noodles.springframework.beans.factory;

import com.noodles.springframework.beans.BeansException;

/**
 * @description: ObjectFactory
 * @author: liuxian
 * @date: 2022-11-14 15:26
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;

}
