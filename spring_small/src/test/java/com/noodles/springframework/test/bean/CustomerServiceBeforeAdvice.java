package com.noodles.springframework.test.bean;

import com.noodles.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * @description: CustomerServiceBeforeAdvice
 * @author: liuxian
 * @date: 2022-11-13 17:15
 */
public class CustomerServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] obejcts, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
