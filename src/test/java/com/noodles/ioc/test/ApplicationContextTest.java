package com.noodles.ioc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: noodles
 * @create: 2021-02-19 08:14
 */
public class ApplicationContextTest {

    @Test
    public void testAlias() {
        String configLocation = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        System.out.println(" alias-hello -> " + context.getBean("alias-hello"));
        System.out.println("double-alias-hello -> " + context.getBean("double-alias-hello"));
    }

    @Test
    public void testAutowired() {
        String configLocation = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("service-without-autowire -> " + context.getBean("service-without-autowire"));
        System.out.println("service-without-autowire -> " + context.getBean("service-with-autowire"));
    }
}
