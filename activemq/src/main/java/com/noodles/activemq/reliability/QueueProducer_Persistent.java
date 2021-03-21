package com.noodles.activemq.reliability;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: 消息生产者(持久化消息)
 * @Author: noodles
 * @create: 2021-03-21 11:02
 */
public class QueueProducer_Persistent {
    public static void main(String[] args) throws JMSException {
        // 1, 创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 2, 创建 Session 对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 3, 创建Queue
        Queue queue = session.createQueue("queue-test");
        // 4, 创建Producer
        MessageProducer producer = session.createProducer(queue);

        // 设置持久化存储, 默认即为持久化消息
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);

        // 5, 创建 TextMessage
        TextMessage message = session.createTextMessage("This is a test");
        // 6, 发送消息
        producer.send(message);
        // 7, 关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
