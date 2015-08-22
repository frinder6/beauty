package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyTableConfig;
import com.beauty.interfaces.TableConfigDao;
import com.beauty.service.BaseService;
import com.beauty.service.IMapperService;

@Service
public class TableConfigService extends BaseService<BeautyTableConfig> implements IMapperService<BeautyTableConfig> {

	@Autowired
	private TableConfigDao tableConfigDao;

	@Override
	public int selectCount(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.tableConfigDao.selectCount(params);
	}

	@Override
	public List<?> selectPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.tableConfigDao.selectPage(params);
	}

	public List<?> selectByTable(BeautyTableConfig config) {
		return this.tableConfigDao.selectByTable(config);
	}

}
