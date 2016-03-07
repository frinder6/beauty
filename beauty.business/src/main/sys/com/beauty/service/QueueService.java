package com.beauty.service;

import com.beauty.entity.BeautyQueue;
import com.beauty.mapper.BeautyQueueMapper;
import com.beauty.mapper.BeautyQueueMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Service
public class QueueService extends BaseService<BeautyQueue> {

    @Autowired
    private BeautyQueueMapper beautyQueueMapper;

    @Autowired
    private BeautyQueueMapperImpl beautyQueueMapperImpl;

    @Override
    public List<?> selectPage(Map<String, Object> params) {
        return this.beautyQueueMapperImpl.selectPage(params);
    }

    @Override
    public int selectCount(Map<String, Object> params) {
        return this.beautyQueueMapperImpl.selectCount(params);
    }

    @Override
    public void updateByPrimaryKeySelective(BeautyQueue entity) {
        // TODO Auto-generated method stub
        this.beautyQueueMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void deleteByPrimaryKeys(List<Object> list) {
        // TODO Auto-generated method stub
        this.beautyQueueMapperImpl.deleteByPrimaryKeys(list);
    }

    @Override
    public BeautyQueue selectByPrimaryKey(Long id) {
        return this.beautyQueueMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertSelective(BeautyQueue entity) {
        // TODO Auto-generated method stub
        this.beautyQueueMapper.insertSelective(entity);
    }


    public List<BeautyQueue> selectByPrimaryKeys(List<Object> list) {
        return this.beautyQueueMapperImpl.selectByPrimaryKeys(list);
    }
}
