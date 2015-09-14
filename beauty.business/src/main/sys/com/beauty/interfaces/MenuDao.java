package com.beauty.interfaces;

import java.util.List;
import java.util.Map;

import com.beauty.dao.IMapperDao;
import com.beauty.entity.BeautyMenu;

public interface MenuDao extends IMapperDao<BeautyMenu> {

	public List<?> selectMenuSelect(Map<String, Object> params);

	public List<?> selectMainMenu(Map<String, Object> params);

}
