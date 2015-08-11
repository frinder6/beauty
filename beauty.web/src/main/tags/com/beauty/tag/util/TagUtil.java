package com.beauty.tag.util;

import java.io.IOException;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;

import com.beauty.sys.entity.BeautyMenu;

public class TagUtil {

	// 二级菜单外层ul
	private static final String _UL = "<ul class=\"big-menu\">%s</ul>";

	// 二级菜单模板
	private static final String _TEMPLATE = "<li class=\"with-right-arrow\"><span><span class=\"list-count\">%s</span>%s</span><ul class=\"big-menu\">%s</ul></li>";

	// 二级菜单li
	private static final String _SIMPLE_LI = "<li><a href=\"javascript:void(0)\" data-href=\"%s\">%s</a></li>";

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

	/**
	 * 
	 * @Title: createLevelMenu
	 * @Description: TODO(生成二级菜单)
	 * @author frinder_liu
	 * @param parentName
	 * @param menus
	 * @return
	 * @throws IOException
	 * @return String
	 * @date 2015年7月29日 上午12:02:11
	 * @throws
	 */
	public static String createLevelMenu(String parentName, List<?> menus) throws IOException {
		// 查询二/三/...级菜单
		// 添加外层ul
		String menuStr = String.format(_TEMPLATE, menus.size(), parentName, createMenu(menus));
		String result = String.format(_UL, menuStr);
		return result;
	}

	/**
	 * 
	 * @Title: createMenu
	 * @Description: TODO(生成二级菜单子方法)
	 * @author frinder_liu
	 * @param menus
	 * @return
	 * @return String
	 * @date 2015年7月29日 上午12:02:28
	 * @throws
	 */
	private static String createMenu(List<?> menus) {
		StringBuffer menuStr = new StringBuffer();
		BeautyMenu menu = null;
		for (Object obj : menus) {
			menu = (BeautyMenu) obj;
			int count = menu.getChildren().size();
			// 存在子节点
			if (count > 0) {
				String temp = createMenu(menu.getChildren());
				menuStr.append(String.format(_TEMPLATE, count, menu.getName(), temp));
			} else {
				menuStr.append(String.format(_SIMPLE_LI, menu.getUrl(), menu.getName()));
			}
		}
		return menuStr.toString();
	}

}
