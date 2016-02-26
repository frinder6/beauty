package com.beauty.service;

import com.beauty.entity.BeautySchemaColumns;
import com.beauty.mapper.BeautySchemaColumnsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchemaColumnsService extends BaseService<BeautySchemaColumns> {

	@Autowired
	private BeautySchemaColumnsMapper beautySchemaColumnsMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautySchemaColumnsMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautySchemaColumnsMapper.selectPage(params);
	}

}
