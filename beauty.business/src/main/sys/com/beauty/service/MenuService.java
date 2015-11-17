package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyMenu;
import com.beauty.interfaces.MenuDao;
import com.beauty.util.RedisUtil;

@Service
public class MenuService extends BaseService<BeautyMenu> {

	@Autowired
	private MenuDao menuDao;

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.menuDao.selectCount(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.menuDao.selectPage(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	public List<?> selectMenuSelect(Map<String, Object> params) {
		return this.menuDao.selectMenuSelect(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	public List<?> selectMainMenu(Map<String, Object> params) {
		return this.menuDao.selectMainMenu(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyMenu entity) {
		// TODO Auto-generated method stub
		this.menuDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.menuDao.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyMenu selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.menuDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyMenu entity) {
		// TODO Auto-generated method stub
		this.menuDao.insertSelective(entity);
	}
}
