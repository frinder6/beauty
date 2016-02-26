package com.beauty.service;

import com.beauty.entity.BeautyAuthority;
import com.beauty.mapper.BeautyAuthorityMapper;
import com.beauty.model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthorityService extends BaseService<BeautyAuthority> {

	@Autowired
	private BeautyAuthorityMapper beautyAuthorityMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityMapper.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(BeautyAuthority entity) {
		// TODO Auto-generated method stub
		this.beautyAuthorityMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		this.beautyAuthorityMapper.deleteByPrimaryKeys(list);
	}

	@Override
	public BeautyAuthority selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return this.beautyAuthorityMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertSelective(BeautyAuthority entity) {
		// TODO Auto-generated method stub
		this.beautyAuthorityMapper.insertSelective(entity);
	}

	public void batchGroup(Value value) {
		this.beautyAuthorityMapper.batchGroup(value);
	}
}
