package com.jf.rockermqstudy.mq.delayed;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送延时消息
 *
 * @author 江峰
 * @date 2020/8/8 16:49
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {
        // 实例化一个生产者来产生延时消息
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        // 设置NameServer的地址
        producer.setNamesrvAddr("139.224.103.236:9876");
        // 启动生产者
        producer.start();
        int totalMessagesToSend = 2;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("topic1", "tag2", ("Hello scheduled message " + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            message.setDelayTimeLevel(2);
            // 发送消息
            producer.send(message);
        }
        // 关闭生产者
        producer.shutdown();
    }
}