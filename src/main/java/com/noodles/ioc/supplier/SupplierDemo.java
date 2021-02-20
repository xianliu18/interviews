package com.noodles.ioc.supplier;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @ClassName supplierDemo
 * @Description Supplier 创建实例
 * @Author noodles
 * @Date 2021/2/20 11:08
 */
public class SupplierDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setInstanceSupplier(SupplierDemo::createUser);
        context.registerBeanDefinition(User.class.getSimpleName(), beanDefinition);
        context.refresh();
        System.out.println(context.getBean(User.class).getName());
    }

    private static User createUser() {
        return new User("张三同学");
    }

    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @PostConstruct
        public void init() {
            System.out.println("User 初始化 ...");
        }
    }
}
