package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyRole;
import com.beauty.mapper.BeautyRoleMapper;
import com.beauty.mapper.BeautyRoleMapperImpl;

@Service
public class RoleService extends BaseService<BeautyRole> {

	@Autowired
	private BeautyRoleMapper beautyRoleMapper;

	@Autowired
	private BeautyRoleMapperImpl beautyRoleMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyRoleMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyRoleMapperImpl.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyRole entity) {
		// TODO Auto-generated method stub
		this.beautyRoleMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyRoleMapperImpl.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyRole selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyRole entity) {
		// TODO Auto-generated method stub
		this.beautyRoleMapper.insertSelective(entity);
	}

	public void batchSync() {
		this.beautyRoleMapperImpl.batchSync();
	}
}
