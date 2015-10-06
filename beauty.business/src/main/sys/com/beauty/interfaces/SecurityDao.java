package com.beauty.interfaces;

import java.util.List;

import com.beauty.entity.BeautyUser;

public interface SecurityDao {

	public List<?> selectUserAuths(Long userId);

	public List<?> selectResourcess();

	public BeautyUser queryByUsername(String account);

}
