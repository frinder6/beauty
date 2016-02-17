package com.beauty.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.beauty.entity.BeautyHandlerLogs;

@Component("amqpItemReaderImpl")
public class AmqpItemReaderImpl implements ItemReader<BeautyHandlerLogs>, InitializingBean {

	private BeautyHandlerLogs log;

	@Override
	public BeautyHandlerLogs read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return log;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	public void handleMessage(BeautyHandlerLogs log) {
		this.log = log;
	}

	public BeautyHandlerLogs getLog() {
		return log;
	}

	public void setLog(BeautyHandlerLogs log) {
		this.log = log;
	}

}
