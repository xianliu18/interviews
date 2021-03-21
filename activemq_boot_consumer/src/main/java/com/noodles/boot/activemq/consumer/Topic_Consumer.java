package com.noodles.boot.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description: topic 消费者
 * @Author: noodles
 * @create: 2021-03-21 20:26
 */
@Component
public class Topic_Consumer {
    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("收到Topic消息:" + textMessage.getText());
    }
}
