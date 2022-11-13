package com.noodles.springframework.test.event;


import com.noodles.springframework.context.ApplicationListener;
import java.util.Date;

/**
 * @description: 自定义事件监听器
 * @author: liuxian
 * @date: 2022-11-13 11:00
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {


    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息；时间：" + new Date());
        System.out.println("消息：" + event.getId() + " : " + event.getMessage());
    }
}
