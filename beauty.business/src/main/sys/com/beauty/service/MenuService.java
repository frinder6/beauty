package com.beauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.base.dao.IDao;
import com.beauty.base.service.BaseService;
import com.beauty.entity.BeautyMenu;

@Service
public class MenuService extends BaseService<BeautyMenu> {

	@Autowired
	private IDao<BeautyMenu> menuDao;

}
