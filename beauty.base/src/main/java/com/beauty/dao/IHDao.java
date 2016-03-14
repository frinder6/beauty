package com.beauty.dao;

import com.beauty.entity.Page;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by frinder_liu on 2016/3/10.
 */
public interface IHDao<T> {

    /**
     *
     * @param entity
     */
    public void persist(T entity);

    /**
     *
     * @param entity
     */
    public void remove(T entity);

    /**
     *
     * @param entity
     */
    public void merge(T entity);

    /**
     *
     * @param clazz
     * @param id
     * @return
     */
    public T findById(Class<T> clazz, Long id);

    /**
     *
     * @param clazz
     * @return
     */
    public List<T> query(Class<T> clazz);


}
