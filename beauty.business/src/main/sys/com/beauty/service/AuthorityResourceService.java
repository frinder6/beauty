package com.beauty.service;

import com.beauty.entity.BeautyAuthorityResource;
import com.beauty.mapper.BeautyAuthorityResourceMapper;
import com.beauty.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthorityResourceService extends BaseService<BeautyAuthorityResource> {

	@Autowired
	private BeautyAuthorityResourceMapper beautyAuthorityResourceMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityResourceMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityResourceMapper.selectPage(params);
	}

	public int selectConfCount(Map<String, Object> params) {
		return this.beautyAuthorityResourceMapper.selectConfCount(params);
	}

	public List<?> selectConfPage(Map<String, Object> params) {
		return this.beautyAuthorityResourceMapper.selectConfPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyAuthorityResource entity) {
		// TODO Auto-generated method stub
		this.beautyAuthorityResourceMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyAuthorityResourceMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyAuthorityResource selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityResourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyAuthorityResource entity) {
		// TODO Auto-generated method stub
		this.beautyAuthorityResourceMapper.insertSelective(entity);
	}

	public void insert(Value value) {
		this.beautyAuthorityResourceMapper.insert(value);
	}
}
