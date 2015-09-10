package com.beauty.interfaces;

import java.util.List;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyResource;

public interface ResourceDao extends IMapperDao<BeautyResource> {

	public void updateByPrimaryKeySelective(BeautyResource entity);

	public void deleteByPrimaryKeys(List<Object> list);

}
