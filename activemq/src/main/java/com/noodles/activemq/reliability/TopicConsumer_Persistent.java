package com.noodles.activemq.reliability;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import java.io.IOException;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: Topic 消费者(持久化, 发布订阅)
 * @Author: noodles
 * @create: 2021-03-21 11:49
 */
public class TopicConsumer_Persistent {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String TOPIC_NAME = "topic-Persist";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("Topic 1号消费者");
        // 1, 创建Connection, 并开启
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("Tom");
        connection.start();
        // 创建Session, 并设置Destination
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "remark...");

        connection.start();

        Message message = durableSubscriber.receive();
        while (null != message) {
            TextMessage textMessage = (TextMessage)message;
            System.out.println("**** 收到的持久化消息: " + textMessage.getText());
            message = durableSubscriber.receive(1000L);
        }

        // 关闭资源
        session.close();
        connection.close();
    }
}
