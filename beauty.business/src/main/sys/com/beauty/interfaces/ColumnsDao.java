package com.beauty.interfaces;

import java.util.List;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.Columns;

public interface ColumnsDao extends IMapperDao<Columns> {

	public List<?> selectByGridName(String gridName);

}
