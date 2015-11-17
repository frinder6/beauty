package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyHandlerLogs;
import com.beauty.interfaces.LogDao;

@Service
public class LogService extends BaseService<BeautyHandlerLogs> {

	@Autowired
	private LogDao logDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.logDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.logDao.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.logDao.deleteByPrimaryKeys(list);
	}

	@Override
	public void insertSelective(BeautyHandlerLogs entity) {
		// TODO Auto-generated method stub
		this.logDao.insertSelective(entity);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyHandlerLogs entity) {
		// TODO Auto-generated method stub
		super.updateByPrimaryKeySelective(entity);
	}

}
