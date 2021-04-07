package com.noodles.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName TopicDemo
 * @Description Topic 示例
 * @Author noodles
 * @Date 2021/4/7 16:27
 */
public class TopicDemo {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1， 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2， 设置参数
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/noodles");
        // 3, 创建 Connection
        Connection connection = factory.newConnection();
        // 4，创建 Channel
        Channel channel = connection.createChannel();
        // 5, 创建交换机
        String exchangeName = "test_topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null);

        // 6， 创建队列
        String queueName1 = "topic_queue1";
        String queueName2 = "topic_queue2";
        channel.queueDeclare(queueName1, true, false, false, null);
        channel.queueDeclare(queueName2, true, false, false, null);

        // 7， 绑定队列和交换机
        channel.queueBind(queueName1, exchangeName, "#.error");
        channel.queueBind(queueName1, exchangeName, "order.*");
        channel.queueBind(queueName2, exchangeName, "*.*");


        String body = "Order info~~~";
        String errorBody = "Direct Demo error~~~";
        // 8， 发送消息
        channel.basicPublish(exchangeName, "order.info", null, body.getBytes());

        // 9，释放资源
        channel.close();
        connection.close();
    }
}
