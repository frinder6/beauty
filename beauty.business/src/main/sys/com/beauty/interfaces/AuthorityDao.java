package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyAuthority;
import com.beauty.model.Value;

public interface AuthorityDao extends IMapperDao<BeautyAuthority> {

	public void batchGroup(Value value);
	
}
