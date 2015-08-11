package com.beauty.controller;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.base.service.IService;
import com.beauty.sys.entity.BeautyTableConfig;

@Component
@RequestMapping("/table")
public class TableConfigController {

	@Autowired
	private IService<BeautyTableConfig> tableConfigService;

	@RequestMapping(value = "/load/table/config", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> query(BeautyTableConfig config) {
		config.setTableName("TB_MENU");
		DetachedCriteria criteria = DetachedCriteria.forClass(BeautyTableConfig.class);
		criteria.add(Example.create(config).ignoreCase().excludeZeroes());
		criteria.addOrder(Order.asc("sequence"));
		return this.tableConfigService.query(criteria);
	}

}
