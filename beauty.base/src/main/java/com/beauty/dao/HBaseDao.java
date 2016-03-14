package com.beauty.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frinder_liu on 2016/3/10.
 */
@Repository
public class HBaseDao<T> implements IHDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void persist(T entity) {
        // TODO Auto-generated method stub
        this.getSession().persist(entity);
    }

    @Override
    public void remove(T entity) {
        // TODO Auto-generated method stub
        this.getSession().delete(entity);
    }

    @Override
    public void merge(T entity) {
        // TODO Auto-generated method stub
        this.getSession().merge(entity);
    }

    @Override
    public T findById(Class<T> clazz, Long id) {
        // TODO Auto-generated method stub
        return (T) this.getSession().load(clazz, id);
    }

    @Override
    public List<T> query(Class<T> clazz) {
        // TODO Auto-generated method stub
        return this.getSession().createCriteria(clazz).list();
    }


}
