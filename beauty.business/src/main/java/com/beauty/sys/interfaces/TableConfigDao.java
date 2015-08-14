package com.beauty.sys.interfaces;

import java.util.List;

import com.beauty.base.dao.IMapperDao;
import com.beauty.sys.entity.BeautyTableConfig;

public interface TableConfigDao extends IMapperDao<BeautyTableConfig> {

	public List<?> selectByTable(BeautyTableConfig config);

}
