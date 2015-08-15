package com.beauty.sys.interfaces;

import java.util.List;
import java.util.Map;

import com.beauty.base.dao.IMapperDao;
import com.beauty.sys.entity.SysColumns;

public interface SysColumnsDao extends IMapperDao<SysColumns> {

	public List<?> selectColumnsByTable(Map<String, Object> params);
	
}
