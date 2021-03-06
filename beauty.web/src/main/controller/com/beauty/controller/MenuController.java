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

import com.beauty.entity.BeautyMenu;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.MenuService;
import com.beauty.util.CodeUtil;
import com.beauty.util.StringUtil;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/select", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> select(@RequestParam("search") String search, @RequestParam("pid") String pid) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtil.valueOf(search).length() > 0) {
			params.put("searchValue", search);
		}
		if (StringUtil.valueOf(pid).length() > 0) {
			params.put("pid", pid);
		}
		return this.menuService.selectMenuSelect(params);
	}

	@RequestMapping(value = "/add", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value persist(BeautyMenu menu) {
		this.menuService.persist(menu);
		return new Value(CodeUtil.ADD_SUCCESS);
	}

	@RequestMapping(value = "/update", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value modify(BeautyMenu menu) {
		this.menuService.merge(menu);
		return new Value(CodeUtil.EDIT_SUCCESS);
	}

	@RequestMapping(value = "/remove", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value delete(Value value) {
		if (!value.getValues().isEmpty()) {
			List<String> ids = value.getValues();
			for (String id : ids) {
				this.menuService.remove(this.menuService.findById(BeautyMenu.class, Long.parseLong(id)));
			}
		}
		return new Value(CodeUtil.DELETE_SUCCESS);
	}

	@RequestMapping(value = "/load/id", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BeautyMenu loadMenu(@RequestParam("id") Long id) {
		return this.menuService.findById(BeautyMenu.class, id);
	}

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyMenu menu) {
		Page page = new Page();
		page.init(request);
		Map<String, Object> params = new HashMap<String, Object>();
		// 将page值设置到map中
		page.pageToMap(BeautyMenu.class, params);
		int count = this.menuService.selectCount(params);
		List<?> list = this.menuService.selectPage(params);
		page.setResult(list, count + "", count + "");
		return page;
	}

}
