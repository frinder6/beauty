package com.beauty.interfaces;

import java.util.List;
import java.util.Map;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyTableColumns;
import com.beauty.model.Value;

public interface ColumnsDao extends IMapperDao<BeautyTableColumns> {

	public List<?> selectByGridName(Map<String, Object> params);

	public void batchExport(Value value);

	public void batchCopy(Value value);

}
