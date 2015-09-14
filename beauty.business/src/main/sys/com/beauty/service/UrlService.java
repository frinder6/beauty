package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUrl;
import com.beauty.interfaces.UrlDao;

@Service
public class UrlService extends BaseService<BeautyUrl> implements IMapperService<BeautyUrl> {

	@Autowired
	private UrlDao urlDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.urlDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.urlDao.selectPage(params);
	}
	
	
	@Override
	public void insertSelective(BeautyUrl entity) {
		// TODO Auto-generated method stub
		this.urlDao.insertSelective(entity);
	}

	
	@Override
	public BeautyUrl selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.urlDao.selectByPrimaryKey(id);
	}
}
