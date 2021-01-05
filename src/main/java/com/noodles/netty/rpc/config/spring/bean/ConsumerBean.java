package com.noodles.netty.rpc.config.spring.bean;

import com.noodles.netty.rpc.config.ConsumerConfig;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: 消费者实体
 * @Author: noodles
 * @create: 2021-01-05 07:34
 */
public class ConsumerBean<T> extends ConsumerConfig<T> implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return refer();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
