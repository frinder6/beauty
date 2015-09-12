package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.SysColumns;
import com.beauty.interfaces.SysColumnsDao;
import com.beauty.service.IMapperService;

@Service
public class SysColumnsService implements IMapperService<SysColumns> {

	@Autowired
	private SysColumnsDao sysColumnsDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysColumnsDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysColumnsDao.selectPage(params);
	}
	
	public List<?> selectColumnsByTable(Map<String, Object> params){
		return this.sysColumnsDao.selectColumnsByTable(params);
	}

	@Override
	public void updateByPrimaryKeySelective(SysColumns entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByPrimaryKeys(List<Object> list) {
		// TODO Auto-generated method stub
		
	}

}
