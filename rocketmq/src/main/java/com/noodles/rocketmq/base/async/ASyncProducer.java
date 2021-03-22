package com.noodles.rocketmq.base.async;

import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @Description: 发送异步消息
 * @Author: noodles
 * @create: 2021-03-22 22:41
 */
public class ASyncProducer {

    public static final String MQ_GROUP = "myGroup";
    public static final String ROCKETMQ_URL = "localhost:9876";
    public static final String TOPIC_NAME = "Async_TopicTest";

    public static void main(String[] args) throws Exception {
        // 1, 创建生产者 Producer
        DefaultMQProducer producer = new DefaultMQProducer(MQ_GROUP);
        // 2, 设置 NameServer 地址
        producer.setNamesrvAddr(ROCKETMQ_URL);
        // 设置超时时间为一分钟, 默认 3000
        producer.setSendMsgTimeout(60000);
        // 启动 Producer
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            // 创建消息, 并指定Topic, Tag和消息体
            Message msg = new Message(TOPIC_NAME,
                    "TagB",
                    ("Hello RocketMQ ---> " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送异步消息, SendCallback 接收异步返回结果的回调
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });

            TimeUnit.SECONDS.sleep(1);
        }
        // 关闭 producer
//        producer.shutdown();
    }
}
