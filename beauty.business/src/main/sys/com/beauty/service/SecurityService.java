package com.beauty.service;

import com.beauty.entity.BeautyUser;
import com.beauty.mapper.BeautySecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {

	@Autowired
	private BeautySecurityMapper beautySecurityMapper;

	public List<?> selectUserAuths(Long userId) {
		return this.beautySecurityMapper.selectUserAuths(userId);
	}

	public List<?> selectResourcess() {
		return this.beautySecurityMapper.selectResourcess();
	}

	public BeautyUser queryByUsername(String account) {
		return this.beautySecurityMapper.queryByUsername(account);
	}
}
