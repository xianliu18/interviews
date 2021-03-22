package com.noodles.activemq.queue.redelivery;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.io.IOException;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

/**
 * @Description: 消息消费者
 * @Author: noodles
 * @create: 2021-03-21 11:12
 */
public class JmsConsumer_Redelivery {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue-redelivery";

    public static void main(String[] args) throws JMSException, IOException {
        // 创建Connection
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // 默认接收6次, 自定义重发策略为 3 次
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setMaximumRedeliveries(3);

        connectionFactory.setRedeliveryPolicy(redeliveryPolicy);

        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 创建Session
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建Consumer
        MessageConsumer consumer = session.createConsumer(queue);

        TextMessage message;
        while (true)
        {
            message = (TextMessage)consumer.receive(1000L);
            if (null != message) {
                System.out.println("收到的消息内容: " + message.getText());
            } else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();

        System.out.println("***** 消息接收完成!");
    }
}
