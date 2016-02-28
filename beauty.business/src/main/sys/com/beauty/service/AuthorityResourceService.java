package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyAuthorityResource;
import com.beauty.mapper.BeautyAuthorityResourceMapper;
import com.beauty.mapper.BeautyAuthorityResourceMapperImpl;
import com.beauty.model.Value;

@Service
public class AuthorityResourceService extends BaseService<BeautyAuthorityResource> {

	@Autowired
	private BeautyAuthorityResourceMapper beautyAuthorityResourceMapper;

	@Autowired
	private BeautyAuthorityResourceMapperImpl beautyAuthorityResourceMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityResourceMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityResourceMapperImpl.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyAuthorityResource entity) {
		// TODO Auto-generated method stub
		this.beautyAuthorityResourceMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyAuthorityResourceMapperImpl.deleteByPrimaryKeys(list);
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
		this.beautyAuthorityResourceMapperImpl.insert(value);
	}
}
