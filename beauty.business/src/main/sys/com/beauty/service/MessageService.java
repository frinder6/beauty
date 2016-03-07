package com.beauty.service;

import java.util.List;
import java.util.Map;

import com.beauty.entity.BeautyAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyMessage;
import com.beauty.mapper.BeautyMessageMapper;
import com.beauty.mapper.BeautyMessageMapperImpl;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Service
public class MessageService extends BaseService<BeautyMessage> {

    @Autowired
    private BeautyMessageMapper beautyMessageMapper;

    @Autowired
    private BeautyMessageMapperImpl beautyMessageMapperImpl;

    @Override
    public List<?> selectPage(Map<String, Object> params) {
        return this.beautyMessageMapperImpl.selectPage(params);
    }

    @Override
    public int selectCount(Map<String, Object> params) {
        return this.beautyMessageMapperImpl.selectCount(params);
    }


    @Override
    public void updateByPrimaryKeySelective(BeautyMessage entity) {
        // TODO Auto-generated method stub
        this.beautyMessageMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void deleteByPrimaryKeys(List<Object> list) {
        // TODO Auto-generated method stub
        this.beautyMessageMapperImpl.deleteByPrimaryKeys(list);
    }

    @Override
    public BeautyMessage selectByPrimaryKey(Long id) {
        // TODO Auto-generated method stub
        return this.beautyMessageMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insertSelective(BeautyMessage entity) {
        // TODO Auto-generated method stub
        this.beautyMessageMapper.insertSelective(entity);
    }

    public void batchMark(List<Object> list) {
        this.beautyMessageMapperImpl.batchMark(list);
    }

    public List<?> selectByAccount(Map<String, Object> params){
        return this.beautyMessageMapperImpl.selectByAccount(params);
    }
}
