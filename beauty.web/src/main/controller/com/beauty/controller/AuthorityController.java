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

import com.beauty.entity.BeautyAuthority;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.AuthorityService;
import com.beauty.util.CodeUtil;
import com.beauty.util.DatatablesUtil;
import com.beauty.util.StringUtil;

@Controller
@RequestMapping("/auth")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyAuthority entity) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyAuthority.class, params);
		int count = this.authorityService.selectCount(params);
		List<?> list = this.authorityService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

	@RequestMapping(value = "/group", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value group(Value value) {
		value.setData(StringUtil.hashCode(value.getValue()));
		this.authorityService.batchGroup(value);
		return new Value(CodeUtil.SUCCESS);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyAuthority entity) {
		this.authorityService.insertSelective(entity);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyAuthority entity) {
		this.authorityService.updateByPrimaryKeySelective(entity);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			this.authorityService.deleteByPrimaryKeys(value.getValues());
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyAuthority load(@RequestParam("id") Long id) {
		return this.authorityService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/inline", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value inline(HttpServletRequest request) {
		String action = DatatablesUtil.getAction(request.getParameterMap());
		if ("create".equalsIgnoreCase(action)) {
			BeautyAuthority entity = DatatablesUtil.convert(BeautyAuthority.class, request.getParameterMap());
			entity.setId(null); // 重置id生成策略
			this.authorityService.insertSelective(entity);
			return new Value(entity);
		} else if ("edit".equalsIgnoreCase(action)) {
			List<BeautyAuthority> entitys = DatatablesUtil.convert2(BeautyAuthority.class, request.getParameterMap());
			for (BeautyAuthority entity : entitys) {
				this.authorityService.updateByPrimaryKeySelective(entity);
			}
			return new Value(entitys);
		} else if ("remove".equalsIgnoreCase(action)) {
			List<Object> list = DatatablesUtil.getIds(request.getParameterMap());
			this.authorityService.deleteByPrimaryKeys(list);
		}
		return new Value();
	}

}
