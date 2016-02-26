package com.beauty.mapper;

import com.beauty.entity.BeautyUser;

import java.util.List;

public interface BeautySecurityMapper {

	public List<?> selectUserAuths(Long userId);

	public List<?> selectResourcess();

	public BeautyUser queryByUsername(String account);

}
