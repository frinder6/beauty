package com.beauty.mapper;

import com.beauty.dao.IMapperImpl;

import java.util.List;
import java.util.Map;

public interface BeautyMessageMapperImpl extends IMapperImpl {

    void batchMark(List<Object> list);

    List<?> selectByAccount(Map<String, Object> params);
}
