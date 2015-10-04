package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUserRole;
import com.beauty.interfaces.UserRoleDao;
import com.beauty.model.Value;

@Service
public class UserRoleService extends BaseService<BeautyUserRole> implements IMapperService<BeautyUserRole> {

	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.userRoleDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.userRoleDao.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.userRoleDao.deleteByPrimaryKeys(list);
	}

	public void insert(Value value) {
		this.userRoleDao.insert(value);
	}
}
