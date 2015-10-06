package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyResource;
import com.beauty.model.Value;

public interface ResourceDao extends IMapperDao<BeautyResource> {

	public void batchGroup(Value value);

}
