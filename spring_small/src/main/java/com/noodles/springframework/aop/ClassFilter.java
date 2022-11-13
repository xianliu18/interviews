package com.noodles.springframework.aop;

/**
 * @description: 类过滤器
 * @author: liuxian
 * @date: 2022-11-13 11:24
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);

}
