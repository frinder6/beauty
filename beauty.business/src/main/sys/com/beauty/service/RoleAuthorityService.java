package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyRoleAuthority;
import com.beauty.interfaces.RoleAuthorityDao;
import com.beauty.model.Value;

@Service
public class RoleAuthorityService extends BaseService<BeautyRoleAuthority> {

	@Autowired
	private RoleAuthorityDao roleAuthorityDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.roleAuthorityDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.roleAuthorityDao.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.roleAuthorityDao.deleteByPrimaryKeys(list);
	}

	public void insert(Value value) {
		this.roleAuthorityDao.insert(value);
	}

	public List<?> selectConfPage(Map<String, Object> params) {
		return this.roleAuthorityDao.selectConfPage(params);
	}

	public int selectConfCount(Map<String, Object> params) {
		return this.roleAuthorityDao.selectConfCount(params);
	}
}
