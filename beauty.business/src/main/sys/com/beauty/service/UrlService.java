package com.beauty.service;

import com.beauty.entity.BeautyUrl;
import com.beauty.mapper.BeautyUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UrlService extends BaseService<BeautyUrl> {

	@Autowired
	private BeautyUrlMapper beautyUrlMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUrlMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUrlMapper.selectPage(params);
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
		this.beautyUrlMapper.batchMark(list);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyUrlMapper.deleteByPrimaryKeys(list);
	}
}
