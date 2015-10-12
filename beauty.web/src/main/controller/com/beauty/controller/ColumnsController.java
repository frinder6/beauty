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

import com.beauty.entity.Columns;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.ColumnsService;
import com.beauty.util.CodeUtil;

@Controller
@RequestMapping("/columns")
public class ColumnsController {

	@Autowired
	private ColumnsService columnsService;

	@RequestMapping(value = "/load/columns", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> loadColumns(@RequestParam("gridName") String gridName) {
		return this.columnsService.selectByGridName(gridName);
	}

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, Columns entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(Columns.class, params);
		int count = this.columnsService.selectCount(params);
		List<?> list = this.columnsService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(Columns entity) {
		this.columnsService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(Columns entity) {
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
	public Columns load(@RequestParam("id") Long id) {
		return this.columnsService.selectByPrimaryKey(id);
	}

}
