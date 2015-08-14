package com.beauty.util;

import java.lang.reflect.Field;

import com.beauty.annotation.Orderable;

/**
 * 
 * @ClassName: ColumnUtil
 * @Description: TODO(获取属性对应列名)
 * @author frinder_liu
 * @date 2015年8月14日 下午11:04:24
 *
 */
public class ColumnUtil {

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

}
