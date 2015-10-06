package com.beauty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUser;
import com.beauty.interfaces.SecurityDao;

@Service
public class SecurityService {

	@Autowired
	private SecurityDao securityDao;

	public List<?> selectUserAuths(Long userId) {
		return this.securityDao.selectUserAuths(userId);
	}

	public List<?> selectResourcess() {
		return this.securityDao.selectResourcess();
	}

	public BeautyUser queryByUsername(String account) {
		return this.securityDao.queryByUsername(account);
	}
}
