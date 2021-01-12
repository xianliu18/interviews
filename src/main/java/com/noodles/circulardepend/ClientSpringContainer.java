package com.noodles.circulardepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ClientSpringContainer
 * @Description spring 容器
 * @Author noodles
 * @Date 2021/1/12 16:08
 */
public class ClientSpringContainer {
    public static void main(String[] args) {
        ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
    }
}
