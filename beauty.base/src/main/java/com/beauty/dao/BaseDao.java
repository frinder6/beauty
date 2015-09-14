package com.beauty.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.beauty.entity.Page;

@Component("baseDao")
public class BaseDao<T> implements IDao<T> {

	@Autowired(required = true)
	protected SqlSession sqlSessionTemplate;

	// @Autowired(required = true)
	protected HibernateTemplate hibernateTemplate;

	// @Autowired(required = true)
	protected SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

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
	public List<?> query(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public int queryPageCount(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return ((Long) this.hibernateTemplate.findByCriteria(criteria.setProjection(Projections.rowCount())).get(0)).intValue();
	}

	@Override
	public void queryPage(DetachedCriteria criteria, Page page) {
		// TODO Auto-generated method stub
		int count = ((Long) this.hibernateTemplate.findByCriteria(criteria.setProjection(Projections.rowCount())).get(0)).intValue();
		criteria.setProjection(null);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		List<?> data = this.hibernateTemplate.findByCriteria(criteria, Integer.parseInt(page.getStart()), Integer.parseInt(page.getLength()));
		page.setResult(data, count + "", count + "");
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
	public List<T> queryPage(String sql, T entity, Page page) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql, entity);
	}

	@Override
	public List<T> queryPage(String sql, Map<String, Object> params, Page page) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectList(sql, params);
	}

	@Override
	public int queryPageCount(String sql, T entity) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne(sql, entity);
	}

	@Override
	public int queryPageCount(String sql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne(sql, params);
	}

}
