package com.noodles.activemq.topic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import java.io.IOException;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: Topic 消费者
 * @Author: noodles
 * @create: 2021-03-21 11:49
 */
public class TopicConsumer {
    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("1号消费者");
        // 1, 创建Connection, 并开启
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 创建Session, 并设置Destination
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("topic-test");
        // 设置consumer
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener((message) -> {
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        // 关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
