package com.beauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.beauty.base.service.IService;
import com.beauty.sys.entity.BeautyMenu;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private IService<BeautyMenu> menuService;

	@RequestMapping("/load")
	public void loadMenu() {
		//List<?> menus = this.menuService.query(BeautyMenu.class);
		BeautyMenu m = this.menuService.findById(BeautyMenu.class, 1L);
		System.out.println(JSON.toJSONString(m));
	}

}
