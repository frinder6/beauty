package com.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beauty.base.service.IService;
import com.beauty.entity.BeautyAuthority;

@Component
public class AuthorityController {

	@Autowired
	private IService<BeautyAuthority> authorityService;

}
