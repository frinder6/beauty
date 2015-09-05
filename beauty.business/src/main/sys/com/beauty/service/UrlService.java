package com.beauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUrl;
import com.beauty.interfaces.UrlDao;

@Service
public class UrlService extends BaseService<BeautyUrl> {

	@Autowired
	private UrlDao urlDao;

}
