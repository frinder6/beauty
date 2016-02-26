package com.beauty.mapper;

import com.beauty.dao.IMapper;
import com.beauty.entity.BeautyUserRole;
import com.beauty.model.Value;

public interface BeautyUserRoleMapper extends IMapper<BeautyUserRole> {

	public void insert(Value value);

}
