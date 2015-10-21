package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beauty.dao.IDao;
import com.beauty.entity.Page;

@Component("baseService")
public class BaseService<T> implements IService<T>, IMapperService<T> {

	@Autowired
	private IDao<T> baseDao;

	@Override
	public List<T> query(String sql) {
		// TODO Auto-generated method stub
		return this.baseDao.query(sql);
	}

	@Override
	public List<T> query(String sql, T entity) {
		// TODO Auto-generated method stub
		return this.baseDao.query(sql, entity);
	}

	@Override
	public List<T> query(String sql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.baseDao.query(sql, params);
	}

	@Override
	public List<T> queryPage(String sql, T entity, Page page) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPage(sql, entity, page);
	}

	@Override
	public List<T> queryPage(String sql, Map<String, Object> params, Page page) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPage(sql, params, page);
	}

	@Override
	public int queryPageCount(String sql, T entity) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPageCount(sql, entity);
	}

	@Override
	public int queryPageCount(String sql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPageCount(sql, params);
	}

	@Override
	public T selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateByPrimaryKeySelective(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertSelective(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<?> selectConfPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectConfCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

}
