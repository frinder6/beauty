package com.beauty.mapper;

import com.beauty.dao.IMapperImpl;
import com.beauty.entity.BeautyJob;

import java.util.List;

public interface BeautyJobMapperImpl extends IMapperImpl {

    List<BeautyJob> selectByPrimaryKeys(List<Object> list);

}