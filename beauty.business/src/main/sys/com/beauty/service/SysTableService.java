package com.beauty.service;

import com.beauty.entity.SysTables;
import com.beauty.mapper.SysTablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysTableService extends BaseService<SysTables> {

	@Autowired
	private SysTablesMapper sysTablesMapper;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysTablesMapper.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.sysTablesMapper.selectPage(params);
	}

}
