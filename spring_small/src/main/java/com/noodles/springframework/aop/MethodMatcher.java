package com.noodles.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description: 方法匹配器
 * @author: liuxian
 * @date: 2022-11-13 11:26
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);

}
