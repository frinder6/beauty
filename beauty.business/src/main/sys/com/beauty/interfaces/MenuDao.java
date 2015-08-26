package com.beauty.interfaces;

import java.util.List;
import java.util.Map;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyTableConfig;

public interface MenuDao extends IMapperDao<BeautyTableConfig> {

	public List<?> selectMenuSelect(Map<String, Object> params);
}
