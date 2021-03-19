package com.noodles.circulardepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @ClassName ClientSpringContainer
 * @Description spring 容器
 *
 * 参考链接: https://www.bilibili.com/video/BV1zb411M7NQ?p=154
 *
 * @Author noodles
 * @Date 2021/1/12 16:08
 */
public class ClientSpringContainer {
    public static void main(String[] args) {
//        ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
        Room room = context.getBean("room", Room.class);
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
    }
}
