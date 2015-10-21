package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyResource;
import com.beauty.interfaces.ResourceDao;
import com.beauty.model.Value;

@Service
public class ResourceService extends BaseService<BeautyResource> {

	@Autowired
	private ResourceDao resourceDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.resourceDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.resourceDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyResource entity) {
		this.resourceDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		this.resourceDao.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyResource selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.resourceDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyResource entity) {
		// TODO Auto-generated method stub
		this.resourceDao.insertSelective(entity);
	}

	public void batchGroup(Value value) {
		this.resourceDao.batchGroup(value);
	}
}
