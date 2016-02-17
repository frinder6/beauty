package com.beauty.mq.callback;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component("sendRecoveryCallback")
public class SendRecoveryCallback<T> implements RecoveryCallback<T> {

	@Override
	public T recover(RetryContext cxt) throws Exception {
		System.out.println("---------------recover call back------------------------------------------");
		System.out.println(JSON.toJSONString(cxt));
		return null;
	}

}
