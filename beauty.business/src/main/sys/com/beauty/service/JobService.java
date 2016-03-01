package com.beauty.service;

import com.beauty.entity.BeautyQueue;
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
public class JobService extends BaseService<BeautyQueue> {

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
}
