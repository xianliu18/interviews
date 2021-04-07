package com.noodles.spring.listener;

import com.rabbitmq.client.Channel;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @ClassName QosListener
 * @Description 消费端限流
 * @Author noodles
 * @Date 2021/4/7 19:09
 */
public class QosListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        // 1, 获取消息
        System.out.println(new String(message.getBody()));

        // 2, 处理业务逻辑

        // 3, 签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }
}
