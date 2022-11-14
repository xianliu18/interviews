package com.noodles.springframework.utils;

/**
 * @description: Filter
 * @author: liuxian
 * @date: 2022-11-13 22:50
 */
@FunctionalInterface
public interface Filter<T> {

    boolean accept(T t);

}
