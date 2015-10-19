package com.beauty.interfaces;

import java.util.List;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyTableColumns;
import com.beauty.model.Value;

public interface ColumnsDao extends IMapperDao<BeautyTableColumns> {

	public List<?> selectByGridName(String tableName);

	public void batchExport(Value value);

}
