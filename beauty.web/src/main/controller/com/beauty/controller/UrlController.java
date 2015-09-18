package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.BeautyUrl;
import com.beauty.entity.Page;
import com.beauty.service.UrlService;

@Controller
@RequestMapping("/url")
public class UrlController {

	@Autowired
	private UrlService urlService;


	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyUrl url) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dialog", request.getParameter("dialog"));
		// 将page值设置到map中
		page.pageToMap(BeautyUrl.class, params);
		int count = this.urlService.selectCount(params);
		List<?> list = this.urlService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

}
