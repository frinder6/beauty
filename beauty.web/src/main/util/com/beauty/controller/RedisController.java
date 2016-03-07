package com.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.model.Value;
import com.beauty.redis.RedisService;
import com.beauty.util.CodeUtil;

@Controller
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisService redisService;

	@RequestMapping("/flush")
	@ResponseBody
	public Value flush() {
		this.redisService.clear();
		return new Value(CodeUtil.SUCCESS);
	}

}
