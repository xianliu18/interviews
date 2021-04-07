package com.noodles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
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

    @Test
    public void testConfirm() {
        // 定义回调函数
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            System.out.println("confirm 方法被执行了...");
            if (ack) {
                // 接收成功
                System.out.println("接收成功，cause内容为空：" + cause);
            } else {
                // 接收失败
                System.out.println("接收失败，原因：" + cause);
            }
        });

        // 发送消息
        rabbitTemplate.convertAndSend("confirm_exchange", "confirm", "message for confirm...");
    }

    @Test
    public void testReturn() {

        // 设置交换机处理失败消息的模式
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
            System.out.println("return 执行了...");
        });
        // 发送消息
        rabbitTemplate.convertAndSend("confirm_exchange", "confirm", "message for return...");
    }
}
