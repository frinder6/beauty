package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyAuthority;
import com.beauty.interfaces.AuthorityDao;

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

}
