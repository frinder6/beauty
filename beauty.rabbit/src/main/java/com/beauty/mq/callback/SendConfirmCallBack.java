package com.beauty.mq.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component("sendConfirmCallBack")
public class SendConfirmCallBack implements ConfirmCallback {


	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
	}

}
