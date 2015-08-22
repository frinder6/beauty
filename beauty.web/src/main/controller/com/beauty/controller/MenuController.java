package com.beauty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.BeautyMenu;
import com.beauty.entity.Page;
import com.beauty.model.Value;
import com.beauty.service.IService;
import com.beauty.tag.util.CopyOfTagUtil;
import com.beauty.util.StringUtil;

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
		return new Value(CopyOfTagUtil.createLevelMenu(menu.getName(), menus));
	}

	@RequestMapping("/load/id")
	@ResponseBody
	public BeautyMenu loadMenu(@RequestParam("id") Long id) {
		return this.menuService.findById(BeautyMenu.class, id);
	}

	@RequestMapping(value = "/load/page", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Page queryPage(HttpServletRequest request, BeautyMenu menu) {
		System.out.println(JSON.toJSONString(request.getParameterMap()));

		Page page = new Page();
		page.init(request);
		DetachedCriteria criteria = DetachedCriteria.forClass(BeautyMenu.class);
		// 查询
		String searchValue = page.getSearchValue();
		if (StringUtil.valueOf(searchValue).length() > 0) {
			searchValue = "%".concat(searchValue).concat("%");
			criteria.add(Restrictions.or(Restrictions.like("name", searchValue), Restrictions.like("code", searchValue), Restrictions.like("url", searchValue), Restrictions.like("remark", searchValue)));
		}
		// 排序
		String order = page.getOrderDir();
		if ("desc".equalsIgnoreCase(order)) {
			criteria.addOrder(Order.desc(page.getOrderColumn()));
		} else {
			criteria.addOrder(Order.asc(page.getOrderColumn()));
		}
		this.menuService.queryPage(criteria, page);
		return page;
	}

}
