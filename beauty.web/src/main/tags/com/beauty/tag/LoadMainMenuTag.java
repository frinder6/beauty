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

@Component
public class LoadMainMenuTag extends RequestContextAwareTag {

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
		out.print("<ul id=\"shortcuts\" role=\"complementary\" class=\"children-tooltip tooltip-right\" style=\"margin-top: -30px;\">");
		String li = "<li class=\"%s\" data-id=\"%s\" data-href=\"%s\"><a href=\"javascript:void(0)\" class=\"%s\" title=\"%s\">%s</a></li>";
		for (Object obj : menus) {
			menu = (BeautyMenu) obj;
			out.print(String.format(li, menu.getDef1(), menu.getId(), menu.getUrl(), menu.getDef2(), menu.getName(), menu.getName()));
		}
		out.print("</ul>");
	}

	public static void main(String[] args) {
		String[] ss = { "<ul id=\"shortcuts\" role=\"complementary\" class=\"children-tooltip tooltip-right\">", "<li><a href=\"./\" class=\"shortcut-dashboard\" title=\"主页\">主页</a></li>", "<li class=\"current\"><a href=\"inbox.html\" class=\"shortcut-messages\" title=\"Messages\">Messages</a></li>", "<li><a href=\"agenda.html\" class=\"shortcut-agenda\" title=\"Agenda\">Agenda</a></li>", "<li><a href=\"tables.html\" class=\"shortcut-contacts\" title=\"Contacts\">Contacts</a></li>", "<li><a href=\"explorer.html\" class=\"shortcut-medias\" title=\"Medias\">Medias</a></li>", "<li><a href=\"sliders.html\" class=\"shortcut-stats\" title=\"Stats\">Stats</a></li>", "<li><a href=\"form.html\" class=\"shortcut-settings\" title=\"Settings\">Settings</a></li>",
				"<li><span class=\"shortcut-notes\" title=\"Notes\">Notes</span></li>", "</ul>" };
		for (String s : ss) {
			System.out.println(String.format("out.print(\"%s\")", s));
		}
	}

}
