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

import com.beauty.entity.BeautyResource;
import com.beauty.entity.BeautyUrl;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.ResourceService;
import com.beauty.service.UrlService;
import com.beauty.util.CodeUtil;
import com.beauty.util.RedisUtil;
import com.beauty.util.StringUtil;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private UrlService urlService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyResource resource) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyResource.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("RESOURCE", params));
		int count = this.resourceService.selectCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("RESOURCE", params));
		List<?> list = this.resourceService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/group", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value group(Value value) {
		value.setData(StringUtil.hashCode(value.getValue()));
		this.resourceService.batchGroup(value);
		return new Value(CodeUtil.SUCCESS);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyResource entity) {
		entity.setCode(StringUtil.code(entity.getName()));
		this.resourceService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyResource entity) {
		entity.setCode(StringUtil.code(entity.getName()));
		this.resourceService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.resourceService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyResource load(@RequestParam("id") Long id) {
		return this.resourceService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value config(Value value) {
		if (!value.getValues().isEmpty()) {
			List<Object> ids = value.getValues();
			BeautyUrl url;
			BeautyResource entity;
			for (Object id : ids) {
				url = this.urlService.selectByPrimaryKey(Long.parseLong(id.toString()));
				entity = new BeautyResource(url.getUrl());
				this.resourceService.insertSelective(entity);
			}
		}
		return new Value(CodeUtil.ADD_SUCCESS);
	}

}
