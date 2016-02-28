package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyTableColumns;
import com.beauty.mapper.BeautyTableColumnsMapper;
import com.beauty.mapper.BeautyTableColumnsMapperImpl;
import com.beauty.model.Value;
import com.beauty.util.RedisUtil;

@Service
public class ColumnsService extends BaseService<BeautyTableColumns> {

	@Autowired
	private BeautyTableColumnsMapper beautyTableColumnsMapper;

	@Autowired
	private BeautyTableColumnsMapperImpl beautyTableColumnsMapperImpl;

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyTableColumnsMapperImpl.selectCount(params);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyTableColumnsMapperImpl.selectPage(params);
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
		this.beautyTableColumnsMapperImpl.deleteByPrimaryKeys(list);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyTableColumns entity) {
		// TODO Auto-generated method stub
		this.beautyTableColumnsMapper.updateByPrimaryKeySelective(entity);
	}

	@Cacheable(value = RedisUtil._REDIS_CACHE_VALUE, key = "#params.get('_REDIS_CACHE_KEY')")
	public List<?> selectByGridName(Map<String, Object> params) {
		return this.beautyTableColumnsMapperImpl.selectByGridName(params);
	}

	public void batchExport(Value value) {
		this.beautyTableColumnsMapperImpl.batchExport(value);
	}

	public void batchCopy(Value value) {
		this.beautyTableColumnsMapperImpl.batchCopy(value);
	}
}
