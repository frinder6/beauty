package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUserRole;
import com.beauty.mapper.BeautyUserRoleMapper;
import com.beauty.mapper.BeautyUserRoleMapperImpl;
import com.beauty.model.Value;

@Service
public class UserRoleService extends BaseService<BeautyUserRole> {

	@Autowired
	private BeautyUserRoleMapper beautyUserRoleMapper;

	@Autowired
	private BeautyUserRoleMapperImpl beautyUserRoleMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserRoleMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserRoleMapperImpl.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyUserRoleMapperImpl.deleteByPrimaryKeys(list);
	}

	public void insert(Value value) {
		this.beautyUserRoleMapperImpl.insert(value);
	}

}
