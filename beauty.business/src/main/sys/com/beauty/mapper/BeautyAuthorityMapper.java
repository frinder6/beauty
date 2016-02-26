package com.beauty.mapper;

import com.beauty.dao.IMapper;
import com.beauty.entity.BeautyAuthority;
import com.beauty.model.Value;

public interface BeautyAuthorityMapper extends IMapper<BeautyAuthority> {

	public void batchGroup(Value value);
	
}
