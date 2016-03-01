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
import com.beauty.model.Value;
import com.beauty.service.ColumnsService;
import com.beauty.util.CodeUtil;
import com.beauty.util.RedisUtil;

@Controller
@RequestMapping("/columns")
public class ColumnsController {

	@Autowired
	private ColumnsService columnsService;

	@RequestMapping(value = "/load/columns", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> loadColumns(@RequestParam("tableName") String tableName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tableName", tableName);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("COLUMNS", params));
		return this.columnsService.selectByGridName(params);
	}

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		String tableName = request.getParameter("tableName");
		params.put("tableName", tableName);
		// 将page值设置到map中
		page.pageToMap(BeautyTableColumns.class, params);
		params.put(RedisUtil._KEY_1, 1);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("COLUMNS", params));
		int count = this.columnsService.selectCount(params);
		params.put(RedisUtil._KEY_2, 2);
		params.put(RedisUtil._REDIS_CACHE_KEY, RedisUtil.getRedisKey("COLUMNS", params));
		List<?> list = this.columnsService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/conf", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value export(Value value) {
		if (!value.getValues().isEmpty()) {
			this.columnsService.batchExport(value);
		}
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/copy", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value copy(Value value) {
		if (!value.getValues().isEmpty()) {
			this.columnsService.batchCopy(value);
		}
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyTableColumns entity) {
		this.columnsService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyTableColumns entity) {
		this.columnsService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.columnsService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyTableColumns load(@RequestParam("id") Long id) {
		return this.columnsService.selectByPrimaryKey(id);
	}

}
