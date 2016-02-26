package com.beauty.mapper;

import com.beauty.dao.IMapper;
import com.beauty.entity.BeautyRole;

public interface BeautyRoleMapper extends IMapper<BeautyRole> {

	public void batchSync();

}
