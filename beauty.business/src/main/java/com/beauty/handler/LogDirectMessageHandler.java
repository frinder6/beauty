package com.beauty.handler;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component("logDirectMessageHandler")
public class LogDirectMessageHandler implements Handler {

	@Override
	public void handleMessage(Object message) {
		System.out.println("------------------------------------------------");
		System.out.println(JSON.toJSONString(message));
		System.out.println("------------------------------------------------");
	}

}
