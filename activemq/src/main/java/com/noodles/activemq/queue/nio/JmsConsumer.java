package com.noodles.activemq.queue.nio;

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
public class JmsConsumer {
    public static void main(String[] args) throws JMSException, IOException {
        // 创建Connection
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("nio://127.0.0.1:61618");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 创建Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("queue-test-nio");
        // 创建Consumer
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        String text = textMessage.getText();
                        System.out.println(text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
