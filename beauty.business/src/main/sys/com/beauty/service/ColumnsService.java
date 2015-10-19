package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyTableColumns;
import com.beauty.interfaces.ColumnsDao;
import com.beauty.model.Value;

@Service
public class ColumnsService extends BaseService<BeautyTableColumns> implements IMapperService<BeautyTableColumns> {

	@Autowired
	private ColumnsDao columnsDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.columnsDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.columnsDao.selectPage(params);
	}

	@Override
	public void insertSelective(BeautyTableColumns entity) {
		// TODO Auto-generated method stub
		this.columnsDao.insertSelective(entity);
	}

	@Override
	public BeautyTableColumns selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.columnsDao.selectByPrimaryKey(id);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.columnsDao.deleteByPrimaryKeys(list);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyTableColumns entity) {
		// TODO Auto-generated method stub
		this.columnsDao.updateByPrimaryKeySelective(entity);
	}

	public List<?> selectByGridName(String tableName) {
		return this.columnsDao.selectByGridName(tableName);
	}

	public void batchExport(Value value) {
		this.columnsDao.batchExport(value);
	}
}
