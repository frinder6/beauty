package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyUser;
import com.beauty.mapper.BeautyUserMapper;
import com.beauty.mapper.BeautyUserMapperImpl;

@Service
public class UserService extends BaseService<BeautyUser> {

	@Autowired
	private BeautyUserMapper beautyUserMapper;

	@Autowired
	private BeautyUserMapperImpl beautyUserMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyUserMapperImpl.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyUser entity) {
		// TODO Auto-generated method stub
		this.beautyUserMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyUserMapperImpl.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyUser selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyUser entity) {
		// TODO Auto-generated method stub
		this.beautyUserMapper.insertSelective(entity);
	}
}
