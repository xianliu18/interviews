package com.noodles.boot;

import com.noodles.config.rabbit.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName ProducerTest
 * @Description boot 整合 RabbitMQ
 * @Author noodles
 * @Date 2021/4/7 17:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    // 1, 注入 RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "boot.test001", "boot mq hello~~~");
    }
}
