package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.BeautyUserRole;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.UserRoleService;
import com.beauty.util.CodeUtil;

@Component
@RequestMapping("/ur")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyUserRole entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("conf", request.getParameter("conf"));
		params.put("userId", request.getParameter("userId"));
		// 将page值设置到map中
		page.pageToMap(BeautyUserRole.class, params);
		int count = this.userRoleService.selectCount(params);
		List<?> list = this.userRoleService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(Value value) {
		this.userRoleService.insert(value);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.userRoleService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

}
