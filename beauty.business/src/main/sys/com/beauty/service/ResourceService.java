package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyResource;
import com.beauty.mapper.BeautyResourceMapper;
import com.beauty.mapper.BeautyResourceMapperImpl;
import com.beauty.model.Value;

@Service
public class ResourceService extends BaseService<BeautyResource> {

	@Autowired
	private BeautyResourceMapper beautyResourceMapper;

	@Autowired
	private BeautyResourceMapperImpl beautyResourceMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyResourceMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyResourceMapperImpl.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyResource entity) {
		this.beautyResourceMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		this.beautyResourceMapperImpl.deleteByPrimaryKeys(list);
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
		this.beautyResourceMapperImpl.batchGroup(value);
	}
}
