package com.noodles.springframework.aop.framework.adapter;


import com.noodles.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description: MethodBeforeAdviceInterceptor
 * @author: liuxian
 * @date: 2022-11-13 16:53
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    public MethodBeforeAdvice getAdvice() {
        return advice;
    }

    public void setAdvice(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        this.advice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return invocation.proceed();
    }
}
