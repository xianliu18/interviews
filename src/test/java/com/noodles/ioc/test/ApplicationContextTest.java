package com.noodles.ioc.test;

import com.noodles.ioc.beanfactory.NewsProvider;
import com.noodles.ioc.beanfactory.NewsProvider2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description: Spring applicationContext 属性测试
 *      参考链接： http://www.tianxiaobo.com/2018/05/30/Spring-IOC-容器源码分析系列文章导读/
 * @Author: noodles
 * @create: 2021-02-19 08:14
 */
public class ApplicationContextTest {

    @Test
    public void testAlias() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        System.out.println(" alias-hello -> " + context.getBean("alias-hello"));
        System.out.println("double-alias-hello -> " + context.getBean("double-alias-hello"));
    }

    @Test
    public void testParentBean() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        System.out.println("hello -> " + context.getBean("hello"));
        System.out.println("hello-child -> " + context.getBean("hello-child"));
    }

    @Test
    public void testAutowired() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        System.out.println("service-without-autowire -> " + context.getBean("service-without-autowire"));
        System.out.println("service-without-autowire -> " + context.getBean("service-with-autowire"));
    }

    @Test
    public void testFactoryBean() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        System.out.println("helloFactory -> " + context.getBean("helloFactory"));
        System.out.println("helloFactory -> " + context.getBean("&helloFactory"));
    }

    @Test
    public void testFactoryMethod() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        System.out.println("staticHelloFactory -> " + context.getBean("staticHelloFactory"));
    }

    @Test
    public void testLoopupMethod() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        NewsProvider provider = (NewsProvider)context.getBean("newsProvider");
        System.out.println(provider.getNews());
        System.out.println(provider.getNews());
    }

    @Test
    public void testLoopupMethod2() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        NewsProvider2 provider = (NewsProvider2)context.getBean("newsProvider2");
        System.out.println(provider.getNews());
        System.out.println(provider.getNews());
    }

    @Test
    public void testLoopupMethod3() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        NewsProvider provider = (NewsProvider)context.getBean("newsProvider3");
        System.out.println("newsProvider -> " + provider);
        System.out.println("news 1  -> " + provider.getNews());
        System.out.println("news 2  -> " + provider.getNews());
    }

    @Test
    public void testBeanPostProcessor() {
        String configLocation = "src/test/resources/applicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
    }
}
