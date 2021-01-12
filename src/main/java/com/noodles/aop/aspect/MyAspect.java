package com.noodles.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAspect
 * @Description 切面类
 * @Author noodles
 * @Date 2021/1/12 15:14
 */
@Aspect
@Component
public class MyAspect {

    @Before("execution(public int com.noodles.aop.impl.CalcServiceImpl.*(..))")
    public void beforeNotify() {
        System.out.println("******** @Before 前置通知");
    }

    @After("execution(public int com.noodles.aop.impl.CalcServiceImpl.*(..))")
    public void afterNotify() {
        System.out.println("******** @After 后置通知");
    }

    @AfterReturning("execution(public int com.noodles.aop.impl.CalcServiceImpl.*(..))")
    public void afterReturningNotify() {
        System.out.println("******** @AfterReturning 我是返回后通知");
    }

    @AfterThrowing("execution(public int com.noodles.aop.impl.CalcServiceImpl.*(..))")
    public void afterThrowingNotify() {
        System.out.println("******** @AfterThrowing 我是异常通知");
    }

    @Around("execution(public int com.noodles.aop.impl.CalcServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue = null;
        System.out.println("环绕通知之前AAA");
        retValue = proceedingJoinPoint.proceed();
        System.out.println("环绕通知之后BBB");
        return retValue;
    }



}
