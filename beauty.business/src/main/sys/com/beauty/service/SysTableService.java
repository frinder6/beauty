package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.SysTables;
import com.beauty.interfaces.SysTableDao;
import com.beauty.service.IMapperService;

@Service
public class SysTableService implements IMapperService<SysTables> {

	@Autowired
	private SysTableDao sysTableDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysTableDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysTableDao.selectPage(params);
	}

	@Override
	public void updateByPrimaryKeySelective(SysTables entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		
	}

}
