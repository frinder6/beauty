package com.beauty.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.BeautyRoleAuthority;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.RoleAuthorityService;
import com.beauty.util.CodeUtil;

@Controller
@RequestMapping("/ra")
public class RoleAuthorityController {

	@Autowired
	private RoleAuthorityService roleAuthorityService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyRoleAuthority entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("conf", request.getParameter("conf"));
		params.put("roleId", request.getParameter("roleId"));
		// 将page值设置到map中
		page.pageToMap(BeautyRoleAuthority.class, params);
		int count = this.roleAuthorityService.selectCount(params);
		List<?> list = this.roleAuthorityService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(Value value) {
		this.roleAuthorityService.insert(value);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.roleAuthorityService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

}
