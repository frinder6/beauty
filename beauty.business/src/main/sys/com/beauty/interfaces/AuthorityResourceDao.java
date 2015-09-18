package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyAuthorityResource;
import com.beauty.model.Value;

public interface AuthorityResourceDao extends IMapperDao<BeautyAuthorityResource> {
	
	public void insert(Value value);

}
