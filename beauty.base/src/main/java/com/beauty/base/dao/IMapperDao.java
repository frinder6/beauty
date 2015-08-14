package com.beauty.base.dao;

import java.util.List;
import java.util.Map;

public interface IMapperDao<T> {
	
	public int selectCount(Map<String, Object> params);

	public List<?> selectPage(Map<String, Object> params);

}
