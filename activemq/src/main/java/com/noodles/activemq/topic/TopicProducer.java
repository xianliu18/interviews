package com.noodles.activemq.topic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: Topic 生产者
 * @Author: noodles
 * @create: 2021-03-21 11:49
 */
public class TopicProducer {
    public static void main(String[] args) throws JMSException {
        // 1, 创建 Connection, 并开启
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 2, 创建 Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 3, 创建 Destination, 使用Topic
        Topic topic = session.createTopic("topic-test");
        MessageProducer producer = session.createProducer(topic);
        for (int i = 0; i <= 6; i++) {
            TextMessage message = session.createTextMessage("This is topic test ----> " + i);
            producer.send(message);
        }
        // 4, 关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
