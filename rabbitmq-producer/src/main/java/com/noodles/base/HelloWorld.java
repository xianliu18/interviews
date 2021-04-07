package com.noodles.base;

import com.google.common.base.Charsets;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName HelloWorld
 * @Description 简单版 helloWorld
 * @Author noodles
 * @Date 2021/4/7 13:58
 */
public class HelloWorld {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1， 创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2, 设置参数
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/noodles");
        // 3， 创建链接 Connection
        Connection connection = factory.newConnection();
        // 4， 创建 Channel
        Channel channel = connection.createChannel();
        // 5， 创建队列 Queue
        channel.queueDeclare("hello_world", true, false, false, null);

        String body = "This is a test";

        // 6, 发送消息
        channel.basicPublish("", "hello_world", null, body.getBytes());

        // 7, 释放资源
        channel.close();
        connection.close();
    }
}
