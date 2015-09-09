package com.beauty.util;

import java.lang.reflect.Field;
import java.util.HashMap;
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
		Field[] fields = clazz.getDeclaredFields();
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
				aim.put("id", key.substring(5, key.indexOf("][")));
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
