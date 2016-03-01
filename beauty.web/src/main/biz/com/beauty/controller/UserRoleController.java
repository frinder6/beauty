package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.BeautyUserRole;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.UserRoleService;
import com.beauty.util.CodeUtil;
import com.beauty.util.RedisUtil;

@Controller
@RequestMapping("/ur")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, @RequestParam("userId") String userId, @RequestParam("table") String table) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("table", table);
		// 将page值设置到map中
		page.pageToMap(BeautyUserRole.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("USER-ROLE", params));
		int count = this.userRoleService.selectCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("USER-ROLE", params));
		List<?> list = this.userRoleService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/load/conf/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryConfPage(HttpServletRequest request, @RequestParam("userId") String userId) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		// 将page值设置到map中
		page.pageToMap(BeautyUserRole.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("USER-ROLE", params));
		int count = this.userRoleService.selectConfCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("USER-ROLE", params));
		List<?> list = this.userRoleService.selectConfPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(Value value) {
		this.userRoleService.insert(value);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.userRoleService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

}
