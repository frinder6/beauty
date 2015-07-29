package com.beauty.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.beauty.base.service.IService;
import com.beauty.model.Value;
import com.beauty.sys.entity.BeautyMenu;
import com.beauty.tag.util.TagUtil;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IService<BeautyMenu> menuService;

	@RequestMapping(value = "/load/level", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Value loadLevelMenu(@RequestParam("id") Long id) throws IOException {
		BeautyMenu menu = this.menuService.findById(BeautyMenu.class, id);
		List<?> menus = this.menuService.query("query-level2-menu", menu);
		return new Value(TagUtil.createLevelMenu(menu.getName(), menus));
	}

	@RequestMapping("/load")
	public void loadMenu() {
		// List<?> menus = this.menuService.query(BeautyMenu.class);
		BeautyMenu m = this.menuService.findById(BeautyMenu.class, 1L);
		System.out.println(JSON.toJSONString(m));
	}

}
