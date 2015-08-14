package com.beauty.util;

import java.lang.reflect.Field;

import org.hibernate.criterion.DetachedCriteria;

import com.beauty.annotation.Need;

/**
 * 
 * @ClassName: HibernateUtil
 * @Description: TODO(Hibernate相关util类)
 * @author frinder_liu
 * @date 2015年8月13日 上午10:18:46
 *
 */
public class HibernateUtil {

	/**
	 * 
	 * @Title: excludeProperties
	 * @Description: TODO(设置类中需要属性)
	 * @author frinder_liu
	 * @param clazz
	 * @param example
	 * @return void
	 * @date 2015年8月13日 下午1:55:46
	 * @throws
	 */
	public static void excludeProperties(Class<?> clazz, DetachedCriteria criteria) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			boolean need = field.isAnnotationPresent(Need.class);
			if (need) {
				criteria.createAlias(field.getName(), field.getName());
			}
		}
	}

}
