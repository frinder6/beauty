package com.beauty.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.BeautyTableConfig;
import com.beauty.entity.Page;
import com.beauty.entity.SysColumns;
import com.beauty.entity.SysTables;
import com.beauty.model.Value;
import com.beauty.service.SysColumnsService;
import com.beauty.service.SysTableService;
import com.beauty.service.TableConfigService;
import com.beauty.util.CodeUtil;

@Component
@RequestMapping("/table")
public class TableConfigController {

	@Autowired
	private TableConfigService tableConfigService;

	@Autowired
	private SysTableService sysTableService;

	@Autowired
	private SysColumnsService sysColumnsService;

	@RequestMapping(value = "/modify/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyTableConfig entity) {
		BeautyTableConfig config = this.tableConfigService.findById(BeautyTableConfig.class, entity.getId());
		if (null != entity.getData()) {
			config.setData(entity.getData());
		}
		if (null != entity.getOrderable()) {
			config.setOrderable(entity.getOrderable());
		}
		if (null != entity.getWidth()) {
			config.setWidth(entity.getWidth());
		}
		if (null != entity.getClassName()) {
			config.setClassName(entity.getClassName());
		}
		if (null != entity.getSequence()) {
			config.setSequence(entity.getSequence());
		}
		this.tableConfigService.merge(config);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/load/table/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> query(BeautyTableConfig config) {
		return this.tableConfigService.selectByTable(config);
	}

	@RequestMapping(value = "/load/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page query(HttpServletRequest request) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyTableConfig.class, params);
		int count = this.tableConfigService.selectCount(params);
		List<?> list = this.tableConfigService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/load/schema/tables", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page querySchemaTables(HttpServletRequest request, @RequestParam("tableSchema") String tableSchema) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(SysTables.class, params);
		params.put("tableSchema", tableSchema);
		int count = this.sysTableService.selectCount(params);
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
		// 将page值设置到map中
		page.pageToMap(SysColumns.class, params);
		params.put("tableSchema", tableSchema);
		params.put("tableName", tableName);
		int count = this.sysColumnsService.selectCount(params);
		List<?> list = this.sysColumnsService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value config(@RequestParam("tableSchema") String tableSchema, @RequestParam("tableName") String tableName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableSchema", tableSchema);
		params.put("tableName", tableName);
		List<?> list = this.sysColumnsService.selectColumnsByTable(params);
		BeautyTableConfig entity;
		SysColumns column;
		for (int i = 0; i < list.size(); i++) {
			column = (SysColumns) list.get(i);
			entity = new BeautyTableConfig(tableName.toUpperCase(), column.getColumnName(), (byte) 1, 50, i, column.getColumnName(), new Date(), new Date());
			this.tableConfigService.persist(entity);
		}
		return new Value(CodeUtil.SUCCESS);
	}

}
