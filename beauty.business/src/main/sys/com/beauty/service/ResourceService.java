package com.beauty.service;

import com.beauty.entity.BeautyResource;
import com.beauty.mapper.BeautyResourceMapper;
import com.beauty.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResourceService extends BaseService<BeautyResource> {

	@Autowired
	private BeautyResourceMapper beautyResourceMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyResourceMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyResourceMapper.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyResource entity) {
		this.beautyResourceMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		this.beautyResourceMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyResource selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyResourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyResource entity) {
		// TODO Auto-generated method stub
		this.beautyResourceMapper.insertSelective(entity);
	}

	public void batchGroup(Value value) {
		this.beautyResourceMapper.batchGroup(value);
	}
}
