package com.noodles.springframework.test;

import com.noodles.springframework.beans.PropertyValue;
import com.noodles.springframework.beans.PropertyValues;
import com.noodles.springframework.beans.factory.config.BeanDefinition;
import com.noodles.springframework.beans.factory.config.BeanReference;
import com.noodles.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.noodles.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.noodles.springframework.context.support.ClassPathXmlApplicationContext;
import com.noodles.springframework.test.bean.UserService;
import com.noodles.springframework.test.common.MyBeanFactoryPostProcessor;
import com.noodles.springframework.test.common.MyBeanPostProcessor;
import com.noodles.springframework.test.event.CustomEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @description: 测试类
 * @author: liuxian
 * @date: 2022-11-11 15:20
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1, 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
//        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3, UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "10003"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4, UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3, 第一次获取 Bean
        UserService userService = (UserService)beanFactory.getBean("userService", "abc");
        userService.queryUserInfo();

    }

    @Test
    public void test_xml() {
        // 1, 初始化 BeeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2, 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3, 获取 Bean 对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_noApplicationContext() {
        // 1, 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2, 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3, BeanDefinition 加载完成 & Bean 实例化之前，修改 BeanDefiniton 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4, Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5, 获取 bean 对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_withAppContext() {
        // 1, 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("withAppContext 测试结果：" + result);
    }

    @Test
    public void test_aware() {
        // 1, 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("aware 测试结果：" + result);
//        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
//        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }

    @Test
    public void test_prototype() {
        // 1, 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 获取 Bean 对象调用方法
        UserService service01 = applicationContext.getBean("userService", UserService.class);
        UserService service02 = applicationContext.getBean("userService", UserService.class);

        // 3, 验证 scope
        System.out.println(service01);
        System.out.println(service02);

        System.out.println(service01 + " 十六进制哈希：" + Integer.toHexString(service01.hashCode()));
        System.out.println(ClassLayout.parseInstance(service01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1, 初始化 Beanfactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2, 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        // 1， 初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了"));

        applicationContext.registerShutdownHook();
    }

}
