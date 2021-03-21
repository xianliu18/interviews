package com.noodles.boot.activemq.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

/**
 * @Description: 配置类
 * @Author: noodles
 * @create: 2021-03-21 19:29
 */
@Component
@EnableJms
public class QueueConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(myQueue);
    }
}
