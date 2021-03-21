package com.noodles.activemq.reliability.tx;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.io.IOException;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: 消息消费者
 * @Author: noodles
 * @create: 2021-03-21 11:12
 */
public class JmsConsumer_TX {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue-tx";

    public static void main(String[] args) throws JMSException, IOException {
        // 创建Connection
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 创建Session
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建Consumer
        MessageConsumer consumer = session.createConsumer(queue);
        while (true)
        {
            TextMessage textMessage = (TextMessage)consumer.receive(4000L);
            if (null != textMessage) {
                System.out.println("*****消费者接收到消息: " + textMessage.getText());
            } else {
                break;
            }
        }

        consumer.close();
        // 开启事务后, 需要commit
        session.commit();
        session.close();
        connection.close();
    }
}
