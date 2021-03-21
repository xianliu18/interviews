package com.noodles.boot.activemq.consumer;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 消费者
 * @Author: noodles
 * @create: 2021-03-21 20:07
 */
@Component
public class Queue_Consumer {

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("*****消费者收到消息: " + textMessage.getText());
    }

}
