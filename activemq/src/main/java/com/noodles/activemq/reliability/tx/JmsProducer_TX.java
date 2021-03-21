package com.noodles.activemq.reliability.tx;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Description: 消息生产者
 * @Author: noodles
 * @create: 2021-03-21 11:02
 */
public class JmsProducer_TX {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue-tx";

    public static void main(String[] args) throws JMSException {
        // 1, 创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        // 2, 创建 Session 对象
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        // 3, 创建Queue
        Queue queue = session.createQueue(QUEUE_NAME);
        // 4, 创建Producer
        MessageProducer producer = session.createProducer(queue);
        for (int i = 1; i <= 3; i++) {
            // 5, 创建 TextMessage
            TextMessage message = session.createTextMessage("This is a test" + i);
            // 6, 发送消息
            producer.send(message);
        }

        // 7, 关闭资源
        producer.close();
        // 开启事务后, 需要commit, 消息才被真正的提交到队列
        session.commit();
        session.close();
        connection.close();
        System.out.println("*****ACK消息发布到MQ完成");
    }
}
