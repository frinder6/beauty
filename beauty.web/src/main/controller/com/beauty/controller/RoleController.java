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

import com.beauty.entity.BeautyRole;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.RoleService;
import com.beauty.util.CodeUtil;
import com.beauty.util.DatatablesUtil;
import com.beauty.util.StringUtil;

@Component
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyRole entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyRole.class, params);
		int count = this.roleService.selectCount(params);
		List<?> list = this.roleService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyRole entity) {
		entity.setCode(StringUtil.code(entity.getName()));
		this.roleService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyRole entity) {
		entity.setCode(StringUtil.code(entity.getName()));
		this.roleService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.roleService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyRole load(@RequestParam("id") Long id) {
		return this.roleService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/inline", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value inline(HttpServletRequest request) {
		String action = DatatablesUtil.getAction(request.getParameterMap());
		if ("create".equalsIgnoreCase(action)) {
			BeautyRole entity = DatatablesUtil.convert(BeautyRole.class, request.getParameterMap());
			entity.setId(null); // 重置id生成策略
			this.roleService.insertSelective(entity);
			return new Value(entity);
		} else if ("edit".equalsIgnoreCase(action)) {
			List<BeautyRole> entitys = DatatablesUtil.convert2(BeautyRole.class, request.getParameterMap());
			for (BeautyRole entity : entitys) {
				this.roleService.updateByPrimaryKeySelective(entity);
			}
			return new Value(entitys);
		} else if ("remove".equalsIgnoreCase(action)) {
			List<Object> list = DatatablesUtil.getIds(request.getParameterMap());
			this.roleService.deleteByPrimaryKeys(list);
		}
		return new Value();
	}

}
