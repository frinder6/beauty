package com.beauty.service;

import com.beauty.entity.BeautyRoleAuthority;
import com.beauty.mapper.BeautyRoleAuthorityMapper;
import com.beauty.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleAuthorityService extends BaseService<BeautyRoleAuthority> {

	@Autowired
	private BeautyRoleAuthorityMapper beautyRoleAuthorityMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyRoleAuthorityMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyRoleAuthorityMapper.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyRoleAuthorityMapper.deleteByPrimaryKeys(list);
	}

	public void insert(Value value) {
		this.beautyRoleAuthorityMapper.insert(value);
	}

	public List<?> selectConfPage(Map<String, Object> params) {
		return this.beautyRoleAuthorityMapper.selectConfPage(params);
	}

	public int selectConfCount(Map<String, Object> params) {
		return this.beautyRoleAuthorityMapper.selectConfCount(params);
	}
}
