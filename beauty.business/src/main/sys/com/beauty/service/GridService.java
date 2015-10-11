package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.Grid;
import com.beauty.interfaces.GridDao;

@Service
public class GridService extends BaseService<Grid> implements IMapperService<Grid> {

	@Autowired
	private GridDao gridDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.gridDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.gridDao.selectPage(params);
	}

	@Override
	public void insertSelective(Grid entity) {
		// TODO Auto-generated method stub
		this.gridDao.insertSelective(entity);
	}

	@Override
	public Grid selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.gridDao.selectByPrimaryKey(id);
	}

	public Grid selectByGridName(String gridName) {
		return this.gridDao.selectByGridName(gridName);
	}
}
