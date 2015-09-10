package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyResource;
import com.beauty.interfaces.ResourceDao;

@Service
public class ResourceService extends BaseService<BeautyResource> implements IMapperService<BeautyResource> {

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

	public void updateByPrimaryKeySelective(BeautyResource entity) {
		this.resourceDao.updateByPrimaryKeySelective(entity);
	}

	public void deleteByPrimaryKeys(List<Object> list) {
		this.resourceDao.deleteByPrimaryKeys(list);
	}

}
