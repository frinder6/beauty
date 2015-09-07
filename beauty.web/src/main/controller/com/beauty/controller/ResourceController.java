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
	public Value persist(BeautyResource resource) {
		this.resourceService.persist(resource);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyResource resource) {
		this.resourceService.merge(resource);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			List<String> ids = value.getValues();
			for (String id : ids) {
				this.resourceService.remove(this.resourceService.findById(BeautyResource.class, Long.parseLong(id)));
			}
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyResource load(@RequestParam("id") Long id) {
		return this.resourceService.findById(BeautyResource.class, id);
	}

	@RequestMapping(value = "/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value config(Value value) {
		if (!value.getValues().isEmpty()) {
			List<String> ids = value.getValues();
			BeautyUrl url;
			BeautyResource resource;
			for (String id : ids) {
				url = this.urlService.findById(BeautyUrl.class, Long.parseLong(id));
				resource = new BeautyResource("", "", url.getUrl(), "");
				this.resourceService.persist(resource);
			}
		}
		return new Value(CodeUtil.ADD_SUCCESS);
	}

}
