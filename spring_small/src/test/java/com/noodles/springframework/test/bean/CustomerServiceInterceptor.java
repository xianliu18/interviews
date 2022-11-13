package com.noodles.springframework.test.bean;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description: 自定义拦截方法
 * @author: liuxian
 * @date: 2022-11-13 12:36
 */
public class CustomerServiceInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            System.out.println("监控 - Begin By AOP...");
            System.out.println("方法名称：" + invocation.getMethod());
            System.out.println("方法耗时：" + (System.currentTimeMillis() - start));
            System.out.println("监控结束\r\n");
        }
    }
}
