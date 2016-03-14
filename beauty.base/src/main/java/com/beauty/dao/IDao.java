package com.beauty.dao;

import com.beauty.entity.Page;

import java.util.List;
import java.util.Map;

public interface IDao<T> {

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
	 * @Title: queryPageCount
	 * @Description: TODO(分页查询记录数)
	 * @author frinder_liu
	 * @param sql
	 * @param entity
	 * @return
	 * @return int
	 * @date 2015年8月9日 下午12:04:58
	 * @throws
	 */
	public int queryPageCount(String sql, T entity);

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
	public List<T> queryPage(String sql, T entity, Page page);

	/**
	 * 
	 * @Title: queryPageCount
	 * @Description: TODO(分页查询记录数)
	 * @author frinder_liu
	 * @param sql
	 * @param params
	 * @return
	 * @return int
	 * @date 2015年8月9日 下午12:04:27
	 * @throws
	 */
	public int queryPageCount(String sql, Map<String, Object> params);

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
	public List<T> queryPage(String sql, Map<String, Object> params, Page page);

}
