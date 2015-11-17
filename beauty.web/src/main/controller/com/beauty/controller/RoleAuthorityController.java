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

import com.beauty.entity.BeautyRoleAuthority;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.RoleAuthorityService;
import com.beauty.util.CodeUtil;
import com.beauty.util.RedisUtil;

@Controller
@RequestMapping("/ra")
public class RoleAuthorityController {

	@Autowired
	private RoleAuthorityService roleAuthorityService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, @RequestParam("roleId") Long roleId) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		// 将page值设置到map中
		page.pageToMap(BeautyRoleAuthority.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("ROLE-AUTHORITY", params));
		int count = this.roleAuthorityService.selectCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("ROLE-AUTHORITY", params));
		List<?> list = this.roleAuthorityService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/load/conf/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryConfPage(HttpServletRequest request, @RequestParam("roleId") Long roleId) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", roleId);
		// 将page值设置到map中
		page.pageToMap(BeautyRoleAuthority.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("ROLE-AUTHORITY", params));
		int count = this.roleAuthorityService.selectConfCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("ROLE-AUTHORITY", params));
		List<?> list = this.roleAuthorityService.selectConfPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(Value value) {
		this.roleAuthorityService.insert(value);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.roleAuthorityService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

}
