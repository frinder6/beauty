package com.beauty.mq.callback;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component("sendReturnCallBack")
public class SendReturnCallBack implements ReturnCallback {

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println("-----------return call back--------------------------------------------------");
		System.out.println(JSON.toJSONString(message));
		System.out.println(replyCode);
		System.out.println(replyText);
		System.out.println(exchange);
		System.out.println(routingKey);
	}

}
