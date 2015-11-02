package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyRole;
import com.beauty.interfaces.RoleDao;

@Service
public class RoleService extends BaseService<BeautyRole> {

	@Autowired
	private RoleDao roleDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.roleDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.roleDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyRole entity) {
		// TODO Auto-generated method stub
		this.roleDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.roleDao.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyRole selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.roleDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyRole entity) {
		// TODO Auto-generated method stub
		this.roleDao.insertSelective(entity);
	}

	public void batchSync() {
		this.roleDao.batchSync();
	}
}
