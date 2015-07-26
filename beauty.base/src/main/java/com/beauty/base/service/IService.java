package com.beauty.base.service;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

public interface IService<T> {
	/**
	 * 
	 * @Title: persist
	 * @Description: TODO(新增)
	 * @author frinder_liu
	 * @param entity
	 * @return void
	 * @date 2015年7月25日 下午2:21:50
	 * @throws
	 */
	public void persist(T entity);

	/**
	 * 
	 * @Title: remove
	 * @Description: TODO(删除)
	 * @author frinder_liu
	 * @param entity
	 * @return void
	 * @date 2015年7月25日 下午2:22:02
	 * @throws
	 */
	public void remove(T entity);

	/**
	 * 
	 * @Title: merge
	 * @Description: TODO(修改)
	 * @author frinder_liu
	 * @param entity
	 * @return void
	 * @date 2015年7月25日 下午2:22:11
	 * @throws
	 */
	public void merge(T entity);

	/**
	 * 
	 * @Title: findById
	 * @Description: TODO(加载单个实体)
	 * @author frinder_liu
	 * @param clazz
	 * @param id
	 * @return
	 * @return T
	 * @date 2015年7月25日 下午2:22:25
	 * @throws
	 */
	public T findById(Class<T> clazz, Long id);

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(hibernate查询)
	 * @author frinder_liu
	 * @param clazz
	 * @return
	 * @return List<?>
	 * @date 2015年7月25日 下午10:20:33
	 * @throws
	 */
	public List<?> query(DetachedCriteria criteria);

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(无参数查询方法)
	 * @author frinder_liu
	 * @param sql
	 * @return
	 * @return List<T>
	 * @date 2015年7月25日 下午2:23:50
	 * @throws
	 */
	public List<T> query(String sql);

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(根据entity查询)
	 * @author frinder_liu
	 * @param sql
	 * @param entity
	 * @return
	 * @return List<T>
	 * @date 2015年7月25日 下午2:24:07
	 * @throws
	 */
	public List<T> query(String sql, T entity);

	/**
	 * 
	 * @Title: query
	 * @Description: TODO(自定义参数查询)
	 * @author frinder_liu
	 * @param sql
	 * @param params
	 * @return
	 * @return List<T>
	 * @date 2015年7月25日 下午2:52:17
	 * @throws
	 */
	public List<T> query(String sql, Map<String, Object> params);

	/**
	 * 
	 * @Title: queryPage
	 * @Description: TODO(根据entity分页查询)
	 * @author frinder_liu
	 * @param sql
	 * @param entity
	 * @return
	 * @return List<T>
	 * @date 2015年7月25日 下午2:53:39
	 * @throws
	 */
	public List<T> queryPage(String sql, T entity);

	/**
	 * 
	 * @Title: queryPage
	 * @Description: TODO(自定义参数分页查询)
	 * @author frinder_liu
	 * @param sql
	 * @param params
	 * @return
	 * @return List<T>
	 * @date 2015年7月25日 下午2:53:03
	 * @throws
	 */
	public List<T> queryPage(String sql, Map<String, Object> params);

}
