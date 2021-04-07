package com.noodles.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName RabbitmqListener
 * @Description 监听器
 * @Author noodles
 * @Date 2021/4/7 17:59
 */
@Component
public class RabbitmqListener {

    @RabbitListener(queues = "boot_queue")
    public void ListerQueue(Message message) {
        System.out.println(message);
    }

}
