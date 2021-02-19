package com.noodles.ioc;

import com.noodles.ioc.service.Hello;
import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName HelloFactoryBean
 * @Description FactoryBean 示例
 * @Author noodles
 * @Date 2021/2/19 10:04
 */
public class HelloFactoryBean implements FactoryBean<Hello> {
    @Override
    public Hello getObject() throws Exception {
        Hello hello = new Hello();
        hello.setContent("hello world");
        return hello;
    }

    @Override
    public Class<?> getObjectType() {
        return Hello.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
