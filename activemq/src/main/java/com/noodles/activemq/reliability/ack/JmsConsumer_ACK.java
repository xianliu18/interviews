package com.noodles.activemq.reliability.ack;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
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
public class JmsConsumer_ACK {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue-ack";

    public static void main(String[] args) throws JMSException, IOException {
        // 创建Connection
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 创建Session
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建Consumer
        MessageConsumer consumer = session.createConsumer(queue);
        while (true)
        {
            TextMessage textMessage = (TextMessage)consumer.receive(4000L);
            if (null != textMessage) {
                System.out.println("*****消费者接收到消息: " + textMessage.getText());
                // Session.CLIENT_ACKNOWLEDGE, 手动签收, 需要设置acknowledge
                // 如果开启事务, 默认自动签收
                textMessage.acknowledge();
            } else {
                break;
            }
        }

        consumer.close();
        session.close();
        connection.close();
    }
}
