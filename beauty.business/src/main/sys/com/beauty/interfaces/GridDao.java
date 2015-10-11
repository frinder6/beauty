package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.Grid;

public interface GridDao extends IMapperDao<Grid> {

	public Grid selectByGridName(String gridName);
	
}
