package com.noodles.springframework.aop;

/**
 * @description: 切点接口
 * @author: liuxian
 * @date: 2022-11-13 11:26
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();

}
