package com.noodles.spring.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @ClassName FanoutListener01
 * @Description TODO
 * @Author liuxian2
 * @Date 2021/4/7 17:15
 */
public class FanoutListener01 implements MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}
