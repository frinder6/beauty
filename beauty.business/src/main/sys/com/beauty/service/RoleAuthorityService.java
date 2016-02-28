package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyRoleAuthority;
import com.beauty.mapper.BeautyRoleAuthorityMapper;
import com.beauty.mapper.BeautyRoleAuthorityMapperImpl;
import com.beauty.model.Value;

@Service
public class RoleAuthorityService extends BaseService<BeautyRoleAuthority> {

	@Autowired
	private BeautyRoleAuthorityMapper beautyRoleAuthorityMapper;

	@Autowired
	private BeautyRoleAuthorityMapperImpl beautyRoleAuthorityMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyRoleAuthorityMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyRoleAuthorityMapperImpl.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyRoleAuthorityMapperImpl.deleteByPrimaryKeys(list);
	}

	public void insert(Value value) {
		this.beautyRoleAuthorityMapperImpl.insert(value);
	}

}
