package com.beauty.mapper;

import com.beauty.dao.IMapperImpl;
import com.beauty.entity.BeautyQueue;

import java.util.List;

public interface BeautyQueueMapperImpl extends IMapperImpl {

    List<BeautyQueue> selectByPrimaryKeys(List<Object> list);

}
