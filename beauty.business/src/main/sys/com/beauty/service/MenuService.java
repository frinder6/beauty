package com.beauty.service;

import com.beauty.entity.BeautyMenu;
import com.beauty.mapper.BeautyMenuMapper;
import com.beauty.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService extends BaseService<BeautyMenu> {

	@Autowired
	private BeautyMenuMapper beautyMenuMapper;

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyMenuMapper.selectCount(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyMenuMapper.selectPage(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	public List<?> selectMenuSelect(Map<String, Object> params) {
		return this.beautyMenuMapper.selectMenuSelect(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	public List<?> selectMainMenu(Map<String, Object> params) {
		return this.beautyMenuMapper.selectMainMenu(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyMenu entity) {
		// TODO Auto-generated method stub
		this.beautyMenuMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyMenuMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyMenu selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyMenuMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyMenu entity) {
		// TODO Auto-generated method stub
		this.beautyMenuMapper.insertSelective(entity);
	}
}
