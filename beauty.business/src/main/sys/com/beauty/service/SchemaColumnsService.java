package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautySchemaColumns;
import com.beauty.mapper.BeautySchemaColumnsMapper;
import com.beauty.mapper.BeautySchemaColumnsMapperImpl;

@Service
public class SchemaColumnsService extends BaseService<BeautySchemaColumns> {

	@Autowired
	private BeautySchemaColumnsMapper beautySchemaColumnsMapper;

	@Autowired
	private BeautySchemaColumnsMapperImpl beautySchemaColumnsMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautySchemaColumnsMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautySchemaColumnsMapperImpl.selectPage(params);
	}

}
