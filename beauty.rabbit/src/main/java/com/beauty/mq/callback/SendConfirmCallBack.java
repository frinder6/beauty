package com.beauty.mq.callback;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component("sendConfirmCallBack")
public class SendConfirmCallBack implements ConfirmCallback {

	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		logger.info("**************************** send confirm callback begin *********************************");
		logger.info(correlationData);
		logger.info("ack : " + ack);
		logger.info(cause);
		logger.info("**************************** send confirm callback end *********************************");
	}

}
