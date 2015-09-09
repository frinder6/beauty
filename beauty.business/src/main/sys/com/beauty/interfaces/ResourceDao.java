package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyResource;

public interface ResourceDao extends IMapperDao<BeautyResource> {

	public void updateByPrimaryKeySelective(BeautyResource entity);

}
