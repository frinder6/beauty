package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beauty.dao.IDao;
import com.beauty.entity.Page;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.beauty.base.service.IService#queryPageCount(org.hibernate.criterion
	 * .DetachedCriteria)
	 */
	@Override
	public int queryPageCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return this.baseDao.queryPageCount(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.beauty.base.service.IService#queryPage(org.hibernate.criterion.
	 * DetachedCriteria, com.beauty.base.entity.Page)
	 */
	@Override
	public void queryPage(DetachedCriteria criteria, Page page) {
		// TODO Auto-generated method stub
		this.baseDao.queryPage(criteria, page);
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

}
