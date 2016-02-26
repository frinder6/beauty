/**    
 * @Title: StringUtil.java  
 * @Package com.mvc.util  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年1月29日 下午5:40:17 
 * @version V1.0   
 */
package com.beauty.util;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName: StringUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年1月29日 下午5:40:17
 * 
 */
public class StringUtil {

	/**
	 * 是否为null或是""
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj){
		return null == obj || obj.toString().trim().length() == 0;
	}

	/**
	 * 
	 * @Title: invalidSql
	 * @Description: TODO(是否为无效sql)
	 * @author frinder_liu
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年11月19日 下午11:04:29
	 * @throws
	 */
	public static String invalidSql(String resource) {
		resource = valueOf(resource);
		if (resource.isEmpty()) {
			return null;
		}
		resource = removeExtraSpace(resource).toLowerCase();
		String[] keys = { "delete", "update", "add", "truncate", "create", "drop", "alter", "select", "or", "or 1=" };
		for (String key : keys) {
			if (resource.indexOf(key) > -1) {
				resource = null;
				break;
			}
		}
		return resource;
	}

	/**
	 * 
	 * @Title: removeExtraSpace
	 * @Description: TODO(去多余空格)
	 * @author frinder_liu
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年11月19日 下午10:53:43
	 * @throws
	 */
	public static String removeExtraSpace(String resource) {
		Pattern p = Pattern.compile(" {2,}");
		Matcher m = p.matcher(resource);
		String second = m.replaceAll(" ");
		return second;
	}

	public static void main(String[] args) {
		String abc = "a   b  c  ";
		System.out.println(removeExtraSpace(abc));
	}

	/**
	 * 
	 * @Title: getValue4Map
	 * @Description: TODO(从map中获取符合条件的value)
	 * @author frinder_liu
	 * @param map
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年10月7日 下午4:26:55
	 * @throws
	 */
	public static String getValue4Map(Map<String, Object> map, String resource) {
		for (String key : map.keySet()) {
			if (resource.indexOf(key) != -1) {
				return map.get(key).toString();
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: hashCode
	 * @Description: TODO(获取字符串的hashcode，返回正数)
	 * @author frinder_liu
	 * @param value
	 * @return
	 * @return int
	 * @date 2015年10月7日 下午4:21:26
	 * @throws
	 */
	public static int hashCode(String value) {
		return Math.abs(value.hashCode());
	}

	/**
	 * 
	 * @Title: md5
	 * @Description: TODO(返回编码的方法)
	 * @author frinder_liu
	 * @param obj
	 * @return
	 * @return String
	 * @date 2015年10月3日 下午10:59:21
	 * @throws
	 */
	public static String code(Object obj) {
		String str;
		if (null == obj) {
			str = "";
		} else {
			str = obj.toString();
		}
		return DigestUtils.md5Hex(str.trim()).toUpperCase();
	}

	/**
	 * 
	 * @Title: getRequestPrefix
	 * @Description: TODO(获取请求根路径)
	 * @author frinder_liu
	 * @param request
	 * @return
	 * @return String
	 * @date 2015年9月18日 下午8:26:12
	 * @throws
	 */
	public static String getRequestPrefix(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		return basePath;
	}

	public static String isNull(Object obj, String def) {
		if (null == obj || obj.toString().length() == 0) {
			return def;
		}
		return obj.toString();
	}

	/**
	 * 
	 * @Title: valueOf
	 * @Description: TODO(重写String.valueOf方法)
	 * @author frinder_liu
	 * @param obj
	 * @return
	 * @return String
	 * @date 2015年5月30日 下午5:13:20
	 * @throws
	 */
	public static String valueOf(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 
	 * @Title: subString
	 * @Description: TODO(截取指定长度的字符串)
	 * @author frinder_liu
	 * @param source
	 * @param maxLen
	 * @return String
	 * @date 2015年2月4日 下午9:10:28 2015 下午9:10:28
	 * @throws
	 */
	public static String subString(String source, int maxLen) {
		int len = source.length();
		if (len <= maxLen) {
			return source;
		} else {
			return source.substring(0, maxLen - 1) + "...";
		}
	}

	/**
	 * 
	 * @Title: getColums
	 * @Description: TODO(获取列)
	 * @author frinder_liu
	 * @param source
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:08:22
	 * @throws
	 */
	public static String getColums(String source) {
		// 接收列
		String colums = " * ";
		// 获取列 名
		if (source.indexOf("*") == -1) {
			// 起始、终止位置索引
			int from, to;
			// 转大写
			String temp = source.toUpperCase();
			from = temp.indexOf("SELECT") + 6;
			to = temp.indexOf("FROM");
			colums = source.substring(from, to);
		}
		return colums;
	}

	/**
	 * 
	 * @Title: getTbname
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param source
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:12:14
	 * @throws
	 */
	public static String getTbname(String source) {
		String tbname;
		int from, to;
		// 转大写
		String temp = source.toUpperCase();
		// 获取表名
		from = temp.indexOf("FROM") + 4;
		if (temp.indexOf("WHERE") > -1) {
			to = temp.indexOf("WHERE");
			tbname = source.substring(from, to);
		} else {
			if (temp.indexOf("LIMIT") > -1) {
				to = temp.indexOf("LIMIT");
				tbname = source.substring(from, to);
			} else {
				tbname = source.substring(from);
			}
		}
		return tbname.trim();
	}

	/**
	 * 
	 * @Title: getWhere
	 * @Description: TODO(获取where条件)
	 * @author frinder_liu
	 * @param source
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:14:21
	 * @throws
	 */
	public static String getWhere(String source) {
		String where = "WHERE 1 = 1";
		int from;
		// 转大写
		String temp = source.toUpperCase();
		// 获取表名
		if (temp.indexOf("WHERE") > -1) {
			from = temp.indexOf("WHERE");
			where = source.substring(from);
		}
		return where;
	}

	/**
	 * 
	 * @Title: aimString
	 * @Description: TODO(获取转换SQL)
	 * @author frinder_liu
	 * @param dbname
	 * @param source
	 * @param type
	 *            1 查询记录明细，2 查询记录数
	 * @return
	 * @return String
	 * @date 2015年2月4日 下午10:22:33
	 * @throws
	 */
	public static String aimString(String dbname, String source, int type) {
		StringBuffer aimStr;
		// 接收列、表名、起始、终止位置索引
		String colums = getColums(source);
		String tbname = getTbname(source);
		String where = getWhere(source);
		if (type == 1) {
			aimStr = new StringBuffer("SELECT %s FROM %s.%s %s");
			return String.format(aimStr.toString(), colums, dbname, tbname, where);
		} else {
			aimStr = new StringBuffer("SELECT count(1) total FROM %s.%s %s");
			return String.format(aimStr.toString(), dbname, tbname, where);
		}
	}

}
