package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyRoleAuthority;
import com.beauty.model.Value;

public interface RoleAuthorityDao extends IMapperDao<BeautyRoleAuthority> {

	public void insert(Value value);

}
