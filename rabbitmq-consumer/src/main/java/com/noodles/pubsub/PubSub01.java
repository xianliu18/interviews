package com.noodles.pubsub;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName HelloWorld
 * @Description 消费者
 * @Author noodles
 * @Date 2021/4/7 14:40
 */
public class PubSub01 {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1， 创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2, 设置参数
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/noodles");
        // 3, 创建链接 Connection
        Connection connection = factory.newConnection();
        // 4, 创建 Channel
        Channel channel = connection.createChannel();

        String queueName1 = "fanout_queue1";

        // 6, 接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag: " + consumerTag);
                System.out.println("Exchange: " + envelope.getExchange());
                System.out.println("RoutingKey: " + envelope.getRoutingKey());
                System.out.println("properties: " + properties);
                System.out.println("body: " + new String(body));
            }
        };

        channel.basicConsume(queueName1, true, consumer);

    }
}
