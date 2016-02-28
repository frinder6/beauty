package com.beauty.service;

import java.util.List;
import java.util.Map;

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
}
