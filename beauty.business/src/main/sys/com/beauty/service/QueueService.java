package com.beauty.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauty.entity.BeautyQueue;
import com.beauty.mapper.BeautyQueueMapper;
import com.beauty.mapper.BeautyQueueMapperImpl;

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
}
