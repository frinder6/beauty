package com.beauty.interfaces;

import java.util.List;
import java.util.Map;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.SysColumns;

public interface SysColumnsDao extends IMapperDao<SysColumns> {

	public List<?> selectColumnsByTable(Map<String, Object> params);
	
}
