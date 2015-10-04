package com.beauty.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.beauty.annotation.Orderable;

/**
 * 
 * @ClassName: ColumnUtil
 * @Description: TODO(获取属性对应列名)
 * @author frinder_liu
 * @date 2015年8月14日 下午11:04:24
 *
 */
public class DatatablesUtil {

	/**
	 * 
	 * @Title: getColumn
	 * @Description: TODO(获取属性对应的列)
	 * @author frinder_liu
	 * @param clazz
	 * @param property
	 * @return
	 * @return String
	 * @date 2015年8月14日 下午11:12:45
	 * @throws
	 */
	public static String getColumn(Class<?> clazz, String property) {
		String column = null;
		// 寻找子类与父类的属性
		Field[] fields = concat(clazz.getDeclaredFields(), clazz.getSuperclass().getDeclaredFields());
		//
		boolean exists = false;
		Orderable orderable = null;
		for (Field field : fields) {
			if (!field.getName().equalsIgnoreCase(property)) {
				continue;
			}
			exists = field.isAnnotationPresent(Orderable.class);
			if (exists) {
				orderable = field.getAnnotation(Orderable.class);
				column = orderable.columnName();
				break;
			}
		}
		return column;
	}

	// 连接2个集合
	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	/**
	 * 
	 * @Title: convert
	 * @Description: 
	 *               TODO(转化格式：{"action":["edit"],"data[1][remark]":["aaaa"]}为entity
	 *               )
	 * @author frinder_liu
	 * @param clazz
	 * @param map
	 * @return
	 * @return T
	 * @date 2015年9月9日 下午10:13:44
	 * @throws
	 */
	public static <T> T convert(Class<T> clazz, @SuppressWarnings("rawtypes") Map map) {
		Map<String, String> aim = new HashMap<String, String>();
		// {"action":["edit"],"data[1][remark]":["aaaa"]}
		for (Object k : map.keySet()) {
			String key = StringUtil.valueOf(k);
			String[] values = (String[]) map.get(k);
			if (!"action".equalsIgnoreCase(key)) {
				if (!aim.containsKey("id")) {
					aim.put("id", key.substring(5, key.indexOf("][")));
				}
				aim.put(key.substring((key.indexOf("][") + 2), key.lastIndexOf("]")), values[0]);
			}
		}
		try {
			// T entity = clazz.newInstance();
			// BeanUtils.copyProperties(entity, aim);
			T entity = JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(aim)), clazz);
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: convert2
	 * @Description: TODO(获取集合)
	 * @author frinder_liu
	 * @param clazz
	 * @param map
	 * @return
	 * @return List<T>
	 * @date 2015年9月11日 下午9:52:50
	 * @throws
	 */
	public static <T> List<T> convert2(Class<T> clazz, @SuppressWarnings("rawtypes") Map map) {
		List<T> entitys = new ArrayList<T>();
		HashSet<String> ids = new HashSet<String>();
		for (Object k : map.keySet()) {
			String key = StringUtil.valueOf(k);
			if (!"action".equalsIgnoreCase(key)) {
				ids.add(key.substring(5, key.indexOf("][")));
			}
		}
		String tid;
		T entity;
		Map<String, String> temp;
		for (String id : ids) {
			temp = new HashMap<String, String>();
			tid = "[".concat(id).concat("]");
			String key;
			String[] values;
			for (Object k : map.keySet()) {
				key = k.toString();
				values = (String[]) map.get(k);
				if (key.indexOf(tid) > -1 && !"action".equalsIgnoreCase(key)) {
					if (!temp.containsKey("id")) {
						temp.put("id", key.substring(5, key.indexOf("][")));
					}
					temp.put(key.substring((key.indexOf("][") + 2), key.lastIndexOf("]")), values[0]);
				}
			}
			entity = JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(temp)), clazz);
			entitys.add(entity);
		}
		return entitys;
	}

	/**
	 * 
	 * @Title: getIds
	 * @Description: TODO(获取所有需要操作的id)
	 * @author frinder_liu
	 * @param map
	 * @return
	 * @return List<Object>
	 * @date 2015年9月10日 下午9:02:13
	 * @throws
	 */
	public static List<Object> getIds(@SuppressWarnings("rawtypes") Map map) {
		HashSet<Object> ids = new HashSet<Object>();
		for (Object k : map.keySet()) {
			String key = StringUtil.valueOf(k);
			if (!"action".equalsIgnoreCase(key)) {
				ids.add(key.substring(5, key.indexOf("][")));
			}
		}
		return new ArrayList<Object>(ids);
	}

	/**
	 * 
	 * @Title: getAction
	 * @Description: TODO(获取操作类型)
	 * @author frinder_liu
	 * @param map
	 * @return
	 * @return String
	 * @date 2015年9月10日 上午12:31:16
	 * @throws
	 */
	public static String getAction(@SuppressWarnings("rawtypes") Map map) {
		String action = "create";
		for (Object k : map.keySet()) {
			String key = StringUtil.valueOf(k);
			String[] values = (String[]) map.get(k);
			if ("action".equalsIgnoreCase(key)) {
				action = values[0];
				break;
			}
		}
		return action;
	}

}
