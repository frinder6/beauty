package com.beauty.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.beauty.sys.entity.BeautyMenu;
import com.beauty.sys.service.MenuService;
import com.beauty.tag.util.TagUtil;
import com.beauty.util.StringUtil;

@Component
public class LoadMainMenuTag extends RequestContextAwareTag {

	// 主菜外围UL
	private static final String _UL_1 = "<ul id=\"main-nav\" class=\"nav nav-pills nav-stacked nav-bracket\">%s</ul>";

	// 主菜单LI
	private static final String _LI_1 = "<li class=\"%s\"><a href=\"javascript:void(0)\"><i class=\"fa %s\"></i> <span>%s</span></a>%s</li>";

	// 二级菜单外围UL
	private static final String _UL_2 = "<ul class=\"children\">%s</ul>";

	// 二级菜单LI
	private static final String _LI_2 = "<li><a href=\"javascript:void(0)\" data-href=\"%s\"><i class=\"fa fa-caret-right\"></i> %s</a></li>";

	private MenuService menuService;

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected int doStartTagInternal() throws Exception {
		// TODO Auto-generated method stub
		try {
			this.menuService = (MenuService) TagUtil.getBean(this.getRequestContext().getWebApplicationContext(), "menuService");
			this.createMainMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * 
	 * @Title: createMainMenu
	 * @Description: TODO(生成主菜单)
	 * @author frinder_liu
	 * @throws IOException
	 * @return void
	 * @date 2015年7月25日 下午1:59:33
	 * @throws
	 */
	private void createMainMenu() throws IOException {
		JspWriter out = this.pageContext.getOut();
		// 查询一级菜单
		DetachedCriteria criteria = DetachedCriteria.forClass(BeautyMenu.class);
		criteria.add(Restrictions.eq("parentId", 0L));
		List<?> menus = this.menuService.query(criteria);
		BeautyMenu menu = null;
		// 主菜单lis
		StringBuffer lisStr = new StringBuffer("");
		// 默认选中
		String defaultClass = "active";
		String parentClass = "nav-parent";
		for (int i = 0; i < menus.size(); i++) {
			// li样式
			String liClass = "";
			menu = (BeautyMenu) menus.get(i);
			if (i == 0) {
				liClass = defaultClass;
			}
			String li_2s = createLevelMenu(menu);
			if (StringUtil.valueOf(li_2s).isEmpty()) {
				// 没有子菜单
				lisStr.append(String.format(_LI_1, liClass, menu.getDef2(), menu.getName(), li_2s));
			} else {
				// 添加父类样式
				liClass = liClass.concat(" ").concat(parentClass);
				lisStr.append(String.format(_LI_1, liClass, menu.getDef2(), menu.getName(), li_2s));
			}
		}
		String menuStr = String.format(_UL_1, lisStr);
		System.out.println(menuStr);
		out.print(menuStr);
	}

	/**
	 * 
	 * @Title: createLevelMenu
	 * @Description: TODO(二级菜单)
	 * @author frinder_liu
	 * @param pMenu
	 * @return
	 * @return String
	 * @date 2015年8月17日 下午10:06:01
	 * @throws
	 */
	private String createLevelMenu(BeautyMenu pMenu) {
		// 查询一级菜单
		DetachedCriteria criteria = DetachedCriteria.forClass(BeautyMenu.class);
		criteria.add(Restrictions.eq("parentId", pMenu.getId()));
		List<?> menus = this.menuService.query(criteria);
		if (menus.isEmpty()) {
			return "";
		}
		BeautyMenu menu = null;
		// 二级菜单lis
		StringBuffer lisStr = new StringBuffer();
		for (Object object : menus) {
			menu = (BeautyMenu) object;
			lisStr.append(String.format(_LI_2, menu.getUrl(), menu.getName()));
		}
		String ul2Str = String.format(_UL_2, lisStr);
		return ul2Str;
	}

}
