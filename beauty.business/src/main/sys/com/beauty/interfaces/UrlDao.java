package com.beauty.interfaces;

import java.util.List;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyUrl;

public interface UrlDao extends IMapperDao<BeautyUrl> {

	public void batchMark(List<Object> list);

}
