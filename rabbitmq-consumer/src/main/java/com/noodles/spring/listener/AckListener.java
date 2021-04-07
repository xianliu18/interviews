package com.noodles.spring.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @ClassName AckListener
 * @Description Ack 确认方式
 * @Author noodles
 * @Date 2021/4/7 19:09
 */
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();

        try {
            // 1, 接收转换消息
            System.out.println(new String(message.getBody()));

            // 2, 处理业务逻辑
            System.out.println("假装在处理业务逻辑...");

            // 3， 手动签收
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            // 4, 拒绝签收
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
