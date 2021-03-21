package com.noodles.boot.activemq;

import javax.annotation.Resource;

import com.noodles.boot.activemq.producer.Queue_Producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Description: 测试类
 * @Author: noodles
 * @create: 2021-03-21 19:40
 */
@SpringBootTest(classes = MainApp_Producer.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
    @Resource
    private Queue_Producer queue_producer;

    @Test
    public void testSend() {
        queue_producer.produceMsg();
    }
}
