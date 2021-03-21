package com.noodles.activemq.reliability;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: Topic 生产者(持久化)
 * @Author: noodles
 * @create: 2021-03-21 11:49
 */
public class TopicProducer_Persistent {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String TOPIC_NAME = "topic-Persist";

    public static void main(String[] args) throws JMSException {
        // 1, 创建 Connection, 并开启
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();

        // 2, 创建 Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 3, 创建 Destination, 使用Topic
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        connection.start();

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
