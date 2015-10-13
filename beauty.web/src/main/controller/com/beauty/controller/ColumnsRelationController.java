package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.Columns;
import com.beauty.entity.Page;
import com.beauty.service.ColumnsRelationService;

@Controller
@RequestMapping("/crelation")
public class ColumnsRelationController {

	@Autowired
	private ColumnsRelationService columnsRelationService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, Columns entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("conf", request.getParameter("conf"));
		System.err.println("**************************************************"+request.getParameter("conf"));
		params.put("tableName", request.getParameter("tableName"));
		// 将page值设置到map中
		page.pageToMap(Columns.class, params);
		int count = this.columnsRelationService.selectCount(params);
		List<?> list = this.columnsRelationService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

}
