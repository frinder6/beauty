package com.beauty.mapper;

import com.beauty.dao.IMapper;
import com.beauty.entity.BeautyTableColumns;
import com.beauty.model.Value;

import java.util.List;
import java.util.Map;

public interface BeautyTableColumnsMapper extends IMapper<BeautyTableColumns> {

	public List<?> selectByGridName(Map<String, Object> params);

	public void batchExport(Value value);

	public void batchCopy(Value value);

}
