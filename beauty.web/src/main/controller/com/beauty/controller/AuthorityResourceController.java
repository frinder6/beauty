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

import com.beauty.entity.BeautyAuthorityResource;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.AuthorityResourceService;
import com.beauty.util.CodeUtil;

@Controller
@RequestMapping("/ar")
public class AuthorityResourceController {

	@Autowired
	private AuthorityResourceService authorityResourceService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, @RequestParam("type") Integer type) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		// 将page值设置到map中
		page.pageToMap(BeautyAuthorityResource.class, params);
		int count = this.authorityResourceService.selectCount(params);
		List<?> list = this.authorityResourceService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/load/conf/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryConfPage(HttpServletRequest request, @RequestParam("authorityId") Long authorityId, @RequestParam("type") Integer type) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", type);
		params.put("authorityId", authorityId);
		// 将page值设置到map中
		page.pageToMap(BeautyAuthorityResource.class, params);
		int count = this.authorityResourceService.selectConfCount(params);
		List<?> list = this.authorityResourceService.selectConfPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(Value value) {
		this.authorityResourceService.insert(value);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.authorityResourceService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

}
