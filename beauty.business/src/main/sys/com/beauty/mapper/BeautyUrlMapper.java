package com.beauty.mapper;

import com.beauty.dao.IMapper;
import com.beauty.entity.BeautyUrl;

import java.util.List;

public interface BeautyUrlMapper extends IMapper<BeautyUrl> {

	public void batchMark(List<Object> list);

}
