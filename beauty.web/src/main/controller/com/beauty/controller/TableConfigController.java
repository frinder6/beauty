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

import com.beauty.entity.BeautyTableConfig;
import com.beauty.entity.Page;
import com.beauty.entity.SysColumns;
import com.beauty.entity.SysTables;
import com.beauty.model.Value;
import com.beauty.service.SysColumnsService;
import com.beauty.service.SysTableService;
import com.beauty.service.TableConfigService;
import com.beauty.util.CodeUtil;
import com.beauty.util.DatatablesUtil;

@Controller
@RequestMapping("/table")
public class TableConfigController {

	@Autowired
	private TableConfigService tableConfigService;

	@Autowired
	private SysTableService sysTableService;

	@Autowired
	private SysColumnsService sysColumnsService;

	@RequestMapping(value = "/load/table/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> query(BeautyTableConfig entity) {
		return this.tableConfigService.selectByTable(entity);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyTableConfig entity) {
		this.tableConfigService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/copy", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value copy(Value value) {
		if (!value.getValues().isEmpty()) {
			this.tableConfigService.batchCopy(value.getValues());
		}
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/inline", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value inline(HttpServletRequest request) {
		BeautyTableConfig entity = DatatablesUtil.convert(BeautyTableConfig.class, request.getParameterMap());
		String action = DatatablesUtil.getAction(request.getParameterMap());
		if ("create".equalsIgnoreCase(action)) {
			entity.setId(null); // 重置id生成策略
			this.tableConfigService.insertSelective(entity);
		} else if ("edit".equalsIgnoreCase(action)) {
			this.tableConfigService.updateByPrimaryKeySelective(entity);
		} else if ("remove".equalsIgnoreCase(action)) {
			List<Object> list = DatatablesUtil.getIds(request.getParameterMap());
			this.tableConfigService.deleteByPrimaryKeys(list);
		}
		return new Value(entity);
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: TODO(删除配置项)
	 * @author frinder_liu
	 * @param value
	 * @return
	 * @return Value
	 * @date 2015年8月23日 下午6:19:50
	 * @throws
	 */
	@RequestMapping(value = "/remove/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value remove(Value value) {
		if (!value.getValues().isEmpty()) {
			this.tableConfigService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	/**
	 * 
	 * @Title: copyToConf
	 * @Description: TODO(复制列到配置表)
	 * @author frinder_liu
	 * @param request
	 * @param value
	 * @return
	 * @return Value
	 * @date 2015年8月23日 下午6:28:04
	 * @throws
	 */
	@RequestMapping(value = "/copy/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value copyToConf(HttpServletRequest request, Value value) {
		if (!value.getValues().isEmpty()) {
			List<Object> columns = value.getValues();
			String tableName = request.getParameter("tableName");
			BeautyTableConfig entity = null;
			for (int i = 0; i < columns.size(); i++) {
				// 逐个添加
				entity = new BeautyTableConfig(tableName.toUpperCase(), columns.get(i).toString());
				this.tableConfigService.insertSelective(entity);
			}
		}
		return new Value(CodeUtil.SUCCESS);
	}

	/**
	 * 
	 * @Title: modify
	 * @Description: TODO(修改已配置记录)
	 * @author frinder_liu
	 * @param entity
	 * @return
	 * @return Value
	 * @date 2015年8月23日 下午4:26:59
	 * @throws
	 */
	@RequestMapping(value = "/modify/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyTableConfig entity) {
		this.tableConfigService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(加载表格配置记录)
	 * @author frinder_liu
	 * @param request
	 * @param config
	 * @return
	 * @return Page
	 * @date 2015年8月23日 下午4:26:21
	 * @throws
	 */
	@RequestMapping(value = "/load/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page query(HttpServletRequest request, BeautyTableConfig entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyTableConfig.class, params);
		params.put("tableName", entity.getTableName());
		int count = this.tableConfigService.selectCount(params);
		List<?> list = this.tableConfigService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	/**
	 * 
	 * @Title: querySchemaTables
	 * @Description: TODO(加载指定数据库的所有表)
	 * @author frinder_liu
	 * @param request
	 * @param tableSchema
	 * @return
	 * @return Page
	 * @date 2015年8月23日 下午4:26:05
	 * @throws
	 */
	@RequestMapping(value = "/load/schema/tables", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page querySchemaTables(HttpServletRequest request) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(SysTables.class, params);
		int count = this.sysTableService.selectCount(params);
		List<?> list = this.sysTableService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	/**
	 * 
	 * @Title: queryColumnsByTable
	 * @Description: TODO(分页加载表列)
	 * @author frinder_liu
	 * @param request
	 * @param tableSchema
	 * @param tableName
	 * @return
	 * @return Page
	 * @date 2015年8月23日 下午4:25:30
	 * @throws
	 */
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

	/**
	 * 
	 * @Title: config
	 * @Description: TODO(根据表名配置所有属性)
	 * @author frinder_liu
	 * @param tableSchema
	 * @param tableName
	 * @return
	 * @return Value
	 * @date 2015年8月23日 下午4:25:13
	 * @throws
	 */
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
			entity = new BeautyTableConfig(tableName.toUpperCase(), column.getColumnName());
			this.tableConfigService.insertSelective(entity);
		}
		return new Value(CodeUtil.SUCCESS);
	}

}
