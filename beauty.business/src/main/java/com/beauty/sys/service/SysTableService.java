package com.beauty.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.base.service.IMapperService;
import com.beauty.sys.entity.SysTables;
import com.beauty.sys.interfaces.SysTableDao;

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

}
