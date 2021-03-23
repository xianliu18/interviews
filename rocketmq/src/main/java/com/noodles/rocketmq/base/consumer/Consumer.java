package com.noodles.rocketmq.base.consumer;

import java.util.List;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @Description: 消费消息
 * @Author: noodles
 * @create: 2021-03-23 20:38
 */
public class Consumer {

    public static final String MQ_GROUP = "myGroup";
    public static final String ROCKETMQ_URL = "localhost:9876";
    public static final String TOPIC_NAME = "Async_TopicTest";
    public static final String TAG_NAME = "TagB";

    public static void main(String[] args) throws MQClientException {
        // 1, 创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(MQ_GROUP);
        // 2, 指定Nameserver地址
        consumer.setNamesrvAddr(ROCKETMQ_URL);
        // 3, 订阅主题和Tag
        consumer.subscribe(TOPIC_NAME, TAG_NAME);

        // 设置消费模式: 负载均衡 或者 广播模式, 默认为 负载均衡
//        consumer.setMessageModel(MessageModel.BROADCASTING);

        // 4, 设置回调函数, 处理消息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgList, consumeConcurrentlyContext) -> {
            for (MessageExt msg : msgList) {
                System.out.println(new String(msg.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 5, 启动消费者
        consumer.start();
    }
}
