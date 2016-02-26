package com.beauty.service;

import com.beauty.entity.BeautyQueue;
import com.beauty.mapper.BeautyQueueMapper;
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

    @Override
    public List<?> selectPage(Map<String, Object> params) {
        return this.beautyQueueMapper.selectPage(params);
    }

    @Override
    public int selectCount(Map<String, Object> params) {
        return this.beautyQueueMapper.selectCount(params);
    }
}
