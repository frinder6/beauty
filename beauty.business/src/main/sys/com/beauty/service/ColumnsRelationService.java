package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.Columns;
import com.beauty.interfaces.ColumnsRelationDao;

@Service
public class ColumnsRelationService extends BaseService<Columns> implements IMapperService<Columns> {

	@Autowired
	private ColumnsRelationDao columnsRelationDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.columnsRelationDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.columnsRelationDao.selectPage(params);
	}

}
