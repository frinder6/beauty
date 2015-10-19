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

import com.beauty.entity.BeautyTableColumns;
import com.beauty.entity.Page;
import com.beauty.service.SchemaColumnsService;

@Controller
@RequestMapping("/schema")
public class SchemaColumnsController {

	@Autowired
	private SchemaColumnsService schemaColumnsService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, @RequestParam("tableName") String tableName) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableName", tableName);
		// 将page值设置到map中
		page.pageToMap(BeautyTableColumns.class, params);
		int count = this.schemaColumnsService.selectCount(params);
		List<?> list = this.schemaColumnsService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

}
