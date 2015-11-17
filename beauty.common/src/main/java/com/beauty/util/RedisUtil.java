package com.beauty.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.JSON;

public class RedisUtil {

	// 缓存存放地址
	public static final String _REDIS_CACHE_VALUE = "_REDIS_CACHE_VALUE";

	public static final String _REDIS_CACHE_KEY = "_REDIS_CACHE_KEY";

	public static final String _KEY_1 = "_KEY_1";

	public static final String _KEY_2 = "_KEY_2";

	/**
	 * 
	 * @Title: getRedisKey
	 * @Description: TODO(获取redis缓存key)
	 * @author frinder_liu
	 * @param prefix
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年11月12日 下午2:27:16
	 * @throws
	 */
	public static final String getRedisKey(Object prefix, Object resource) {
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String account = "anyone";
		if (null != user) {
			account = user.getUsername();
		}
		String result = account.concat(StringUtil.valueOf(prefix)).concat("_").concat(JSON.toJSONString(resource));
		return String.valueOf(StringUtil.hashCode(result));
	}

}
