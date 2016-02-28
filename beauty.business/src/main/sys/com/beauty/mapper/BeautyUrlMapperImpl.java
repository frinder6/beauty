package com.beauty.mapper;

import com.beauty.dao.IMapperImpl;

import java.util.List;

public interface BeautyUrlMapperImpl extends IMapperImpl {

	public void batchMark(List<Object> list);

}
