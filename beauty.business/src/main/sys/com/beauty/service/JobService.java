package com.beauty.service;

import com.beauty.entity.BeautyJob;
import com.beauty.mapper.BeautyJobMapper;
import com.beauty.mapper.BeautyJobMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Service
public class JobService extends BaseService<BeautyJob> {

    @Autowired
    private BeautyJobMapper beautyJobMapper;

    @Autowired
    private BeautyJobMapperImpl beautyJobMapperImpl;

    @Override
    public List<?> selectPage(Map<String, Object> params) {
        return this.beautyJobMapperImpl.selectPage(params);
    }

    @Override
    public int selectCount(Map<String, Object> params) {
        return this.beautyJobMapperImpl.selectCount(params);
    }


    @Override
    public void updateByPrimaryKeySelective(BeautyJob entity) {
        // TODO Auto-generated method stub
        this.beautyJobMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void deleteByPrimaryKeys(List<Object> list) {
        // TODO Auto-generated method stub
        this.beautyJobMapperImpl.deleteByPrimaryKeys(list);
    }

    @Override
    public BeautyJob selectByPrimaryKey(Long id) {
        return this.beautyJobMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertSelective(BeautyJob entity) {
        // TODO Auto-generated method stub
        this.beautyJobMapper.insertSelective(entity);
    }
}
