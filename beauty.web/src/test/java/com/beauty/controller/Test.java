package com.beauty.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.BeautyResource;
import com.beauty.util.DatatablesUtil;

public class Test {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Map<String, Object> map = new HashMap<String, Object>();
		// {"action":["edit"],"data[1][remark]":["aaaa"]}
		map.put("action", new String[] { "aaa" });
		map.put("data[1][remark]", new String[] { "123456" });

		// Map<String, String> aim = new HashMap<String, String>();
		// for (Entry<String, String> entry : map.entrySet()) {
		// String key = entry.getKey();
		// String value = entry.getValue();
		// if (!"action".equalsIgnoreCase(key)) {
		// int tid = key.indexOf("][");
		// String id = key.substring(5, tid);
		// aim.put("id", id);
		// int tkey = key.indexOf("][") + 2;
		// int lkey = key.lastIndexOf("]");
		// aim.put(key.substring(tkey, lkey), value);
		// }
		// }
		// BeautyResource resource = new BeautyResource();
		// BeanUtils.copyProperties(resource, aim);

		Long t1 = System.currentTimeMillis();
		BeautyResource resource = DatatablesUtil.convert(BeautyResource.class, map);
		Long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		System.out.println(JSON.toJSONString(resource));
	}
}
