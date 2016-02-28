package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUrl;
import com.beauty.mapper.BeautyUrlMapper;
import com.beauty.mapper.BeautyUrlMapperImpl;

@Service
public class UrlService extends BaseService<BeautyUrl> {

	@Autowired
	private BeautyUrlMapper beautyUrlMapper;

	@Autowired
	private BeautyUrlMapperImpl beautyUrlMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUrlMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUrlMapperImpl.selectPage(params);
	}

	@Override
	public void insertSelective(BeautyUrl entity) {
		// TODO Auto-generated method stub
		this.beautyUrlMapper.insertSelective(entity);
	}

	@Override
	public BeautyUrl selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyUrlMapper.selectByPrimaryKey(id);
	}

	public void batchMark(List<Object> list) {
		this.beautyUrlMapperImpl.batchMark(list);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyUrlMapperImpl.deleteByPrimaryKeys(list);
	}
}
