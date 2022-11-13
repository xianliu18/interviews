package com.noodles.springframework.aop;

/**
 * @description: PointcutAdvisor
 * @author: liuxian
 * @date: 2022-11-13 16:38
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
