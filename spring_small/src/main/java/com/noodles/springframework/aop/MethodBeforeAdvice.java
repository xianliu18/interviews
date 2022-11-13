package com.noodles.springframework.aop;

import java.lang.reflect.Method;

/**
 * @description: MethodBeforeAdvice
 * @author: liuxian
 * @date: 2022-11-13 16:38
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] obejcts, Object target) throws Throwable;

}
