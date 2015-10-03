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
import com.beauty.util.DatatablesUtil;
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
		int count = this.resourceService.selectCount(params);
		List<?> list = this.resourceService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
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

	@RequestMapping(value = "/inline", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value inline(HttpServletRequest request) {
		String action = DatatablesUtil.getAction(request.getParameterMap());
		if ("create".equalsIgnoreCase(action)) {
			BeautyResource entity = DatatablesUtil.convert(BeautyResource.class, request.getParameterMap());
			entity.setId(null); // 重置id生成策略
			this.resourceService.insertSelective(entity);
			return new Value(entity);
		} else if ("edit".equalsIgnoreCase(action)) {
			List<BeautyResource> entitys = DatatablesUtil.convert2(BeautyResource.class, request.getParameterMap());
			for (BeautyResource entity : entitys) {
				this.resourceService.updateByPrimaryKeySelective(entity);
			}
			return new Value(entitys);
		} else if ("remove".equalsIgnoreCase(action)) {
			List<Object> list = DatatablesUtil.getIds(request.getParameterMap());
			this.resourceService.deleteByPrimaryKeys(list);
		}
		return new Value();
	}
}
