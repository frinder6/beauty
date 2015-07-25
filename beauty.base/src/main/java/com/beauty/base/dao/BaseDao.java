package com.beauty.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component("baseDao")
public class BaseDao<T> implements IDao<T> {

	@Autowired(required = true)
	protected SqlSession sqlSessionTemplate;

	@Autowired(required = true)
	protected HibernateTemplate hibernateTemplate;

	// @Autowired
	// private JdbcTemplate jdbcTemplate;

	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.persist(entity);
	}

	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.delete(entity);
	}

	@Override
	public void merge(T entity) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.merge(entity);
	}

	@Override
	public T findById(Class<T> clazz, Long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.load(clazz, id);
	}

	@Override
	public List<?> query(Class<T> clazz) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(clazz);
		return this.hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<T> query(String sql) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql);
	}

	@Override
	public List<T> query(String sql, T entity) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql, entity);
	}

	@Override
	public List<T> query(String sql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql, params);
	}

	@Override
	public List<T> queryPage(String sql, T entity) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql, entity);
	}

	@Override
	public List<T> queryPage(String sql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql, params);
	}

}
