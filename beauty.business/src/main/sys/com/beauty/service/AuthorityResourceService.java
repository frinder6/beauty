package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyAuthorityResource;
import com.beauty.interfaces.AuthorityResourceDao;
import com.beauty.model.Value;

@Service
public class AuthorityResourceService extends BaseService<BeautyAuthorityResource> implements IMapperService<BeautyAuthorityResource> {

	@Autowired
	private AuthorityResourceDao authorityResourceDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.authorityResourceDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.authorityResourceDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyAuthorityResource entity) {
		// TODO Auto-generated method stub
		this.authorityResourceDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.authorityResourceDao.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyAuthorityResource selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.authorityResourceDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyAuthorityResource entity) {
		// TODO Auto-generated method stub
		this.authorityResourceDao.insertSelective(entity);
	}
	
	public void insert(Value value){
		this.authorityResourceDao.insert(value);
	}
}
