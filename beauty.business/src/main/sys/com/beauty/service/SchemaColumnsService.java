package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautySchemaColumns;
import com.beauty.interfaces.SchemaColumnsDao;

@Service
public class SchemaColumnsService extends BaseService<BeautySchemaColumns> implements IMapperService<BeautySchemaColumns> {

	@Autowired
	private SchemaColumnsDao schemaColumnsDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.schemaColumnsDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.schemaColumnsDao.selectPage(params);
	}

}
