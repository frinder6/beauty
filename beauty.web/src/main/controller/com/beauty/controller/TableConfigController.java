package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.base.entity.Page;
import com.beauty.base.service.IService;
import com.beauty.sys.entity.BeautyTableConfig;
import com.beauty.sys.service.SysTableService;

@Component
@RequestMapping("/table")
public class TableConfigController {

	@Autowired
	private IService<BeautyTableConfig> tableConfigService;

	@Autowired
	private SysTableService sysTableService;

	@RequestMapping(value = "/load/table/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> query(BeautyTableConfig config) {
		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(BeautyTableConfig.class);
		// criteria.add(Example.create(config).ignoreCase().excludeZeroes().excludeProperty("orderable"));
		// criteria.addOrder(Order.asc("sequence"));
		// return this.tableConfigService.query(criteria);
		return this.tableConfigService.query("BeautyTableConfigMapper.selectByTable", config);
	}

	@RequestMapping(value = "/load/schema/tables", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page querySchemaTables(HttpServletRequest request, @RequestParam("tableSchema") String tableSchema) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("searchValue", page.getSearchValue());
		params.put("tableSchema", tableSchema);
		// int count =
		// this.tableConfigService.queryPageCount("SysTablesMapper.selectCount",
		// params);
		int count = this.sysTableService.selectCount(params);
		params.put("from", Integer.parseInt(page.getStart()));
		params.put("size", Integer.parseInt(page.getLength()));
		// List<?> list =
		// this.tableConfigService.query("SysTablesMapper.selectPage", params);
		List<?> list = this.sysTableService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/load/table/columns", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryColumnsByTable(HttpServletRequest request, @RequestParam("tableSchema") String tableSchema, @RequestParam("tableName") String tableName) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("searchValue", page.getSearchValue());
		params.put("tableSchema", tableSchema);
		params.put("tableName", tableName);
		int count = this.tableConfigService.queryPageCount("SysColumnsMapper.selectCount", params);
		params.put("from", Integer.parseInt(page.getStart()));
		params.put("size", Integer.parseInt(page.getLength()));
		List<?> list = this.tableConfigService.query("SysColumnsMapper.selectPage", params);
		page.setResult(list, count + "", count + "");
		return page;
	}

}
