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
