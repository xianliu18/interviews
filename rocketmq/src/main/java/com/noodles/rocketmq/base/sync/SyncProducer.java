package com.noodles.rocketmq.base.sync;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @Description: 发送同步消息
 * @Author: noodles
 * @create: 2021-03-22 22:41
 */
public class SyncProducer {

    public static final String MQ_GROUP = "myGroup";
    public static final String ROCKETMQ_URL = "localhost:9876";
    public static final String TOPIC_NAME = "TopicTest";

    public static void main(String[] args) throws Exception {
        // 1, 创建生产者 Producer
        DefaultMQProducer producer = new DefaultMQProducer(MQ_GROUP);
        // 2, 设置 NameServer 地址
        producer.setNamesrvAddr(ROCKETMQ_URL);
        // 设置超时时间为一分钟, 默认 3000
        producer.setSendMsgTimeout(60000);
        // 启动 Producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            // 创建消息, 并指定Topic, Tag和消息体
            Message msg = new Message(TOPIC_NAME,
                    "TagA",
                    ("Hello RocketMQ ---> " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到一个 Broker
            SendResult sendResult = producer.send(msg);
            // 判断消息是否成功发送
            System.out.printf("%s%n", sendResult);

            TimeUnit.SECONDS.sleep(1);
        }
        // 关闭 producer
        producer.shutdown();
    }
}
