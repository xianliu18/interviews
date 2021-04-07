package com.noodles.spring.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @ClassName SpringQueueListener
 * @Description 监听器
 * @Author noodles
 * @Date 2021/4/7 17:16
 */
public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        // 打印消息
        System.out.println(new String(message.getBody()));
    }
}
