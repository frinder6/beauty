package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyAuthority;
import com.beauty.interfaces.AuthorityDao;
import com.beauty.model.Value;

@Service
public class AuthorityService extends BaseService<BeautyAuthority> implements IMapperService<BeautyAuthority> {

	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.authorityDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.authorityDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyAuthority entity) {
		// TODO Auto-generated method stub
		this.authorityDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.authorityDao.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyAuthority selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.authorityDao.selectByPrimaryKey(id);
	}

	
	@Override
	public void insertSelective(BeautyAuthority entity) {
		// TODO Auto-generated method stub
		this.authorityDao.insertSelective(entity);
	}
	
	public void batchGroup(Value value){
		this.authorityDao.batchGroup(value);
	}
}
