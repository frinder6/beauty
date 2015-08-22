package com.beauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.IDao;
import com.beauty.entity.BeautyMenu;
import com.beauty.service.BaseService;

@Service
public class MenuService extends BaseService<BeautyMenu> {

	@Autowired
	private IDao<BeautyMenu> menuDao;

}
