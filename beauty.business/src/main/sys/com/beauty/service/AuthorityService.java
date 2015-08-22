package com.beauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.dao.IDao;
import com.beauty.entity.BeautyAuthority;
import com.beauty.service.BaseService;


@Service
public class AuthorityService extends BaseService<BeautyAuthority> {

	@Autowired
	private IDao<BeautyAuthority> authorityDao;
	
}
