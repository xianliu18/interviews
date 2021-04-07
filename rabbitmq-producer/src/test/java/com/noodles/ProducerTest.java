package com.noodles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName ProducerTest
 * @Description Spring 整合测试类
 * @Author noodles
 * @Date 2021/4/7 17:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHelloWorld() {
        // 发送消息
        rabbitTemplate.convertAndSend("spring_queue", "Hello World~~~");
    }

    @Test
    public void testFanout() {
        // 发送消息
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "spring faout message ...");
    }

    @Test
    public void testTopics() {
        // 发送消息
        rabbitTemplate.convertAndSend("spring_topic_exchange", "error.log.001", "spring topic message ~~");
    }
}
