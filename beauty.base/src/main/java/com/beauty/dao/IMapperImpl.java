package com.beauty.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/2/28.
 */
public interface IMapperImpl {

    public int selectCount(Map<String, Object> params);

    public List<?> selectPage(Map<String, Object> params);

    public void deleteByPrimaryKeys(List<Object> list);

}
