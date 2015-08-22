package com.beauty.service;

import java.util.List;
import java.util.Map;

public interface IMapperService<T> {

	public int selectCount(Map<String, Object> params);

	public List<?> selectPage(Map<String, Object> params);

}
