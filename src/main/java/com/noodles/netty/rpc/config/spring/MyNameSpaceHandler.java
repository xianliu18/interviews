package com.noodles.netty.rpc.config.spring;

import com.noodles.netty.rpc.config.spring.bean.ConsumerBean;
import com.noodles.netty.rpc.config.spring.bean.ProviderBean;
import com.noodles.netty.rpc.config.spring.bean.ServerBean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description: 名称空间处理器
 * @Author: noodles
 * @create: 2021-01-05 07:36
 */
public class MyNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new MyBeanDefinitionParser(ConsumerBean.class));
        registerBeanDefinitionParser("provider", new MyBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("server", new MyBeanDefinitionParser(ServerBean.class));
    }
}
