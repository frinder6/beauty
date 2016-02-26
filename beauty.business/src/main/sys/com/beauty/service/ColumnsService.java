package com.beauty.service;

import com.beauty.entity.BeautyTableColumns;
import com.beauty.mapper.BeautyTableColumnsMapper;
import com.beauty.model.Value;
import com.beauty.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ColumnsService extends BaseService<BeautyTableColumns> {

	@Autowired
	private BeautyTableColumnsMapper beautyTableColumnsMapper;

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyTableColumnsMapper.selectCount(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyTableColumnsMapper.selectPage(params);
	}

	@Override
	public void insertSelective(BeautyTableColumns entity) {
		// TODO Auto-generated method stub
		this.beautyTableColumnsMapper.insertSelective(entity);
	}

	@Override
	public BeautyTableColumns selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyTableColumnsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyTableColumnsMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyTableColumns entity) {
		// TODO Auto-generated method stub
		this.beautyTableColumnsMapper.updateByPrimaryKeySelective(entity);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	public List<?> selectByGridName(Map<String, Object> params) {
		return this.beautyTableColumnsMapper.selectByGridName(params);
	}

	public void batchExport(Value value) {
		this.beautyTableColumnsMapper.batchExport(value);
	}

	public void batchCopy(Value value) {
		this.beautyTableColumnsMapper.batchCopy(value);
	}
}
