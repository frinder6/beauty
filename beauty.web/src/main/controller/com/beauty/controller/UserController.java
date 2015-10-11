package com.beauty.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.BeautyUser;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.security.UserInfo;
import com.beauty.service.UserService;
import com.beauty.util.CodeUtil;
import com.beauty.util.DatatablesUtil;

@Component
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/auths", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> getUserAuths() {
		List<String> auths = new ArrayList<String>();
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Collection<GrantedAuthority> authorities = user.getAuthorities();
			for (GrantedAuthority ga : authorities) {
				auths.add(ga.getAuthority());
			}
			return auths;
		} catch (Exception e) {
			return auths;
		}
	}

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyUser entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyUser.class, params);
		int count = this.userService.selectCount(params);
		List<?> list = this.userService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyUser entity) {
		this.userService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyUser entity) {
		this.userService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.userService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyUser load(@RequestParam("id") Long id) {
		return this.userService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/inline", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value inline(HttpServletRequest request) {
		String action = DatatablesUtil.getAction(request.getParameterMap());
		if ("create".equalsIgnoreCase(action)) {
			BeautyUser entity = DatatablesUtil.convert(BeautyUser.class, request.getParameterMap());
			entity.setId(null); // 重置id生成策略
			this.userService.insertSelective(entity);
			return new Value(entity);
		} else if ("edit".equalsIgnoreCase(action)) {
			List<BeautyUser> entitys = DatatablesUtil.convert2(BeautyUser.class, request.getParameterMap());
			for (BeautyUser entity : entitys) {
				this.userService.updateByPrimaryKeySelective(entity);
			}
			return new Value(entitys);
		} else if ("remove".equalsIgnoreCase(action)) {
			List<Object> list = DatatablesUtil.getIds(request.getParameterMap());
			this.userService.deleteByPrimaryKeys(list);
		}
		return new Value();
	}

}
