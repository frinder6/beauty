package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUser;
import com.beauty.interfaces.UserDao;

@Service
public class UserService extends BaseService<BeautyUser> implements IMapperService<BeautyUser> {

	@Autowired
	private UserDao userDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.userDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.userDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyUser entity) {
		// TODO Auto-generated method stub
		this.userDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.userDao.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyUser selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyUser entity) {
		// TODO Auto-generated method stub
		this.userDao.insertSelective(entity);
	}
}
