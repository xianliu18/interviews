package com.noodles.ioc;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @ClassName XmlBeanFactoryDemo
 * @Description XmlBeanFactory创建
 * @Author noodles
 * @Date 2021/2/18 10:57
 */
public class XmlBeanFactoryDemo {
    public static void main(String[] args) {
        // 根据Xml 配置文件创建Resource 资源对象， 该对象中包含了 BeanDefinition 的信息
        ClassPathResource resource = new ClassPathResource("applicationContext.xml");
        // 创建 DefaultListableBeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 创建 XmlBeanDefinitionReader 读取器，用于载入 BeanDefinition，
        // 之所以需要 BeanFactory 作为参数，是因为会将读取的信息回调配置给 factory
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // XmlBeanDefinitionReader 执行载入 BeanDefinition 的方法， 最后回完成 Bean 的载入和注册
        reader.loadBeanDefinitions(resource);
    }
}
