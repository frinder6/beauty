package com.beauty.tag.util;

import org.springframework.web.context.WebApplicationContext;

public class BeanUtil {

	/**
	 * 
	 * @Title: getBean
	 * @Description: TODO(自定义标签中获取spring bean)
	 * @author frinder_liu
	 * @param context
	 * @param beanName
	 * @return
	 * @return Object
	 * @date 2015年7月25日 下午11:13:35
	 * @throws
	 */
	public static Object getBean(WebApplicationContext context, String beanName) {
		return context.getBean(beanName);
	}

}
