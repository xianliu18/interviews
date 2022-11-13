package com.noodles.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @description: Advisor
 * @author: liuxian
 * @date: 2022-11-13 16:38
 */
public interface Advisor {

    Advice getAdvice();

}
