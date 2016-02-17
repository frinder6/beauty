package com.beauty.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.BeautyHandlerLogs;

@Component("amqpItemWriterImpl")
public class AmqpItemWriterImpl implements ItemWriter<BeautyHandlerLogs> {

	@Override
	public void write(List<? extends BeautyHandlerLogs> items) throws Exception {
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		System.out.println(JSON.toJSONString(items));
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
	}

}
