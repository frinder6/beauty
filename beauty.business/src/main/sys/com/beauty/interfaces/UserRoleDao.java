package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyUserRole;
import com.beauty.model.Value;

public interface UserRoleDao extends IMapperDao<BeautyUserRole> {
	
	public void insert(Value value);

}
