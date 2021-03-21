package com.noodles.activemq.spring;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description: 生产者
 * @Author: noodles
 * @create: 2021-03-21 14:42
 */
@Service
public class SpringMQ_Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMQ_Producer producer = (SpringMQ_Producer)ctx.getBean("springMQ_Producer");
        producer.jmsTemplate.send((session)->{
            TextMessage textMessage = session.createTextMessage("***** Spring 和 ActiveMQ 整合成功 *****");
            return textMessage;
        });

        System.out.println("********send task over!");
    }
}
