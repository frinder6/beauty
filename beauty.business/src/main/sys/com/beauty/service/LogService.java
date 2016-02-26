package com.beauty.service;

import com.beauty.entity.BeautyHandlerLogs;
import com.beauty.mapper.BeautyHandlerLogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogService extends BaseService<BeautyHandlerLogs> {

	@Autowired
	private BeautyHandlerLogsMapper beautyHandlerLogsMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyHandlerLogsMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyHandlerLogsMapper.selectPage(params);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyHandlerLogsMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public void insertSelective(BeautyHandlerLogs entity) {
		// TODO Auto-generated method stub
		this.beautyHandlerLogsMapper.insertSelective(entity);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyHandlerLogs entity) {
		// TODO Auto-generated method stub
		super.updateByPrimaryKeySelective(entity);
	}

}
