package com.noodles.boot.activemq.producer;

import javax.jms.Topic;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: topic 生产者
 * @Author: noodles
 * @create: 2021-03-21 20:23
 */
@Component
public class Topic_Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 3000)
    public void produceTopic() {
        System.out.println("准备发送主题消息~~~");
        jmsMessagingTemplate.convertAndSend(topic, "主题消息: " + UUID.randomUUID().toString().substring(0, 6));
    }
}
