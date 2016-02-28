package com.beauty.mapper;

import com.beauty.dao.IMapperImpl;
import com.beauty.model.Value;

import java.util.List;
import java.util.Map;

public interface BeautyTableColumnsMapperImpl extends IMapperImpl {

	public List<?> selectByGridName(Map<String, Object> params);

	public void batchExport(Value value);

	public void batchCopy(Value value);

}
