package com.beauty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beauty.entity.BeautyAuthority;
import com.beauty.service.IService;

@Component
public class AuthorityController {

	@Autowired
	private IService<BeautyAuthority> authorityService;

}
