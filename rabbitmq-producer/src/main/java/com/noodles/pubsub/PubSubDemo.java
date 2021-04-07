package com.noodles.pubsub;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName PubSubDemo
 * @Description Pub-Sub 工作模式
 * @Author noodles
 * @Date 2021/4/7 15:21
 */
public class PubSubDemo {
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
        String exchangeName = "test_fanout";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT, true, false, false, null);

        // 6， 创建队列
        String queueName1 = "fanout_queue1";
        String queueName2 = "fanout_queue2";
        channel.queueDeclare(queueName1, true, false, false, null);
        channel.queueDeclare(queueName2, true, false, false, null);

        // 7， 绑定队列和交换机
        channel.queueBind(queueName1, exchangeName, "");
        channel.queueBind(queueName2, exchangeName, "");


        String body = "Pub Sub Demo~~~";
        // 8， 发送消息
        channel.basicPublish(exchangeName, "", null, body.getBytes());

        // 9，释放资源
        channel.close();
        connection.close();
    }
}
