package com.beauty.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.base.service.IMapperService;
import com.beauty.sys.entity.SysColumns;
import com.beauty.sys.interfaces.SysColumnsDao;

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

}
