package com.beauty.interfaces;

import java.util.List;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyTableConfig;

public interface TableConfigDao extends IMapperDao<BeautyTableConfig> {

	public List<?> selectByTable(BeautyTableConfig config);
	
	public void updateByPrimaryKeySelective(BeautyTableConfig entity);

	public void deleteByPrimaryKeys(List<Object> list);

}
