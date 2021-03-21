package com.noodles.boot.activemq.producer;

import javax.jms.Queue;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author:
 * @create: 2021-03-21 19:29
 */
@Component
public class Queue_Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    public void produceMsg() {
        jmsMessagingTemplate.convertAndSend(queue, "*****发送消息:" + UUID.randomUUID().toString().substring(0,6));
    }
}
