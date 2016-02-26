package com.beauty.service;

import com.beauty.entity.BeautyUserRole;
import com.beauty.mapper.BeautyUserRoleMapper;
import com.beauty.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserRoleService extends BaseService<BeautyUserRole> {

	@Autowired
	private BeautyUserRoleMapper beautyUserRoleMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserRoleMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserRoleMapper.selectPage(params);
	}

	@Override
	public int selectConfCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserRoleMapper.selectConfCount(params);
	}

	@Override
	public List<?> selectConfPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserRoleMapper.selectConfPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyUserRoleMapper.deleteByPrimaryKeys(list);
	}

	public void insert(Value value) {
		this.beautyUserRoleMapper.insert(value);
	}

}
