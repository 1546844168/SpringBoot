package com.jf.rocketmqstudy.mq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 描述:
 *
 * @author: 江峰
 * @create: 2021-04-02 15:53
 * @since: 2.22.1
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "CSS", selectorExpression = "ORDER_CANCEL", consumerGroup = "springboot-mq-consumer-1")
public class TestConsumer implements RocketMQListener<String> {

	@Override
	public void onMessage(String message) {
		log.info("Receive message：" + message);
	}
}