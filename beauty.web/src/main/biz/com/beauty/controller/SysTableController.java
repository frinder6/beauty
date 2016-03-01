package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.Page;
import com.beauty.entity.SysTables;
import com.beauty.service.SysTableService;
import com.beauty.util.RedisUtil;

@Controller
@RequestMapping("/table")
public class SysTableController {

	@Autowired
	private SysTableService sysTableService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(SysTables.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("SYS-TABLE", params));
		int count = this.sysTableService.selectCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("SYS-TABLE", params));
		List<?> list = this.sysTableService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

}
