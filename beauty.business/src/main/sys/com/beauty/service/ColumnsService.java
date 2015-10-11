package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.Columns;
import com.beauty.interfaces.ColumnsDao;

@Service
public class ColumnsService extends BaseService<Columns> implements IMapperService<Columns> {

	@Autowired
	private ColumnsDao columnsDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.columnsDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.columnsDao.selectPage(params);
	}

	@Override
	public void insertSelective(Columns entity) {
		// TODO Auto-generated method stub
		this.columnsDao.insertSelective(entity);
	}

	@Override
	public Columns selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.columnsDao.selectByPrimaryKey(id);
	}

	public List<?> selectByGridName(String gridName) {
		return this.columnsDao.selectByGridName(gridName);
	}
}
