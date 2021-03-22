package com.noodles.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.util.UUID;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

/**
 * @Description: 消息生产者(异步发送消息)
 * @Author: noodles
 * @create: 2021-03-21 11:02
 */
public class JmsProducer_AsyncSend {
    public static void main(String[] args) throws JMSException {
        // 1, 创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 2, 创建 Session 对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 3, 创建Queue
        Queue queue = session.createQueue("queue-async");
        // 4, 创建Producer
        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);
        // 5, 创建 TextMessage
        TextMessage message;
        for (int i = 1; i <= 3; i++) {
            message = session.createTextMessage("message -- " + i);
            message.setJMSMessageID(UUID.randomUUID().toString() + "----order");
            String msgId = message.getJMSMessageID();
            // 6, 发送消息
            producer.send(message, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println(msgId + "has been send ok.");
                }

                @Override
                public void onException(JMSException e) {
                    System.out.println(msgId + "has been send failed.");
                }
            });
        }

        // 7, 关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
