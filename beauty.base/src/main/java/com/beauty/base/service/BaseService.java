package com.beauty.base.service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beauty.base.dao.IDao;

@Component("baseService")
public class BaseService<T> implements IService<T> {

	@Autowired
	private IDao<T> baseDao;

	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub
		this.baseDao.persist(entity);
	}

	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub
		this.baseDao.remove(entity);
	}

	@Override
	public void merge(T entity) {
		// TODO Auto-generated method stub
		this.baseDao.merge(entity);
	}

	@Override
	public T findById(Class<T> clazz, Long id) {
		// TODO Auto-generated method stub
		return this.baseDao.findById(clazz, id);
	}

	@Override
	public List<?> query(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return this.baseDao.query(criteria);
	}

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
	public List<T> queryPage(String sql, T entity) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPage(sql, entity);
	}

	@Override
	public List<T> queryPage(String sql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPage(sql, params);
	}

}
