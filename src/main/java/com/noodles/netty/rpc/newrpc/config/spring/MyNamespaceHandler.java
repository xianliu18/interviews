package com.noodles.netty.rpc.newrpc.config.spring;

import com.noodles.netty.rpc.newrpc.config.spring.bean.ConsumerBean;
import com.noodles.netty.rpc.newrpc.config.spring.bean.ProviderBean;
import com.noodles.netty.rpc.newrpc.config.spring.bean.ServerBean;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @ClassName MyNamespaceHandler
 * @Description 名称空间处理器
 * @Author noodles
 * @Date 2021/1/5 15:03
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("consumer", new MyBeanDefinitionParser(ConsumerBean.class));
        registerBeanDefinitionParser("provider", new MyBeanDefinitionParser(ProviderBean.class));
        registerBeanDefinitionParser("server", new MyBeanDefinitionParser(ServerBean.class));
    }
}
