package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.SysTables;
import com.beauty.mapper.SysTablesMapper;
import com.beauty.mapper.SysTablesMapperImpl;

@Service
public class SysTableService extends BaseService<SysTables> {

	@Autowired
	private SysTablesMapper sysTablesMapper;

	@Autowired
	private SysTablesMapperImpl sysTablesMapperImpl;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysTablesMapperImpl.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysTablesMapperImpl.selectPage(params);
	}

}
