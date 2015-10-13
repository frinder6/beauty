package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.Relation;
import com.beauty.interfaces.RelationDao;

@Service
public class RelationService extends BaseService<Relation> implements IMapperService<Relation> {

	@Autowired
	private RelationDao relationDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.relationDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.relationDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(Relation entity) {
		this.relationDao.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		this.relationDao.deleteByPrimaryKeys(list);
	}

	@Override
	public Relation selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.relationDao.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(Relation entity) {
		// TODO Auto-generated method stub
		this.relationDao.insertSelective(entity);
	}

}
