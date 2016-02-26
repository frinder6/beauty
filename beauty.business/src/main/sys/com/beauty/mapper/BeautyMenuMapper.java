package com.beauty.mapper;

import com.beauty.dao.IMapper;
import com.beauty.entity.BeautyMenu;

import java.util.List;
import java.util.Map;

public interface BeautyMenuMapper extends IMapper<BeautyMenu> {

	public List<?> selectMenuSelect(Map<String, Object> params);

	public List<?> selectMainMenu(Map<String, Object> params);

}
