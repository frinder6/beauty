package com.beauty.interfaces;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyRole;

public interface RoleDao extends IMapperDao<BeautyRole> {

	public void batchSync();

}
