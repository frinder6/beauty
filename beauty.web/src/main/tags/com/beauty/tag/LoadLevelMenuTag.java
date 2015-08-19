package com.beauty.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.beauty.sys.service.MenuService;
import com.beauty.tag.util.CopyOfTagUtil;
import com.beauty.tag.util.TagUtil;

@Component
public class LoadLevelMenuTag extends RequestContextAwareTag {

	private MenuService menuService;

	private Long parentId;

	private String parentName;

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected int doStartTagInternal() throws Exception {
		// TODO Auto-generated method stub
		try {
			this.menuService = (MenuService) TagUtil.getBean(this.getRequestContext().getWebApplicationContext(), "menuService");
			this.createLevelMenu();
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
	private void createLevelMenu() throws IOException {
		JspWriter out = this.pageContext.getOut();
		// 查询二/三/...级菜单
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", parentId);
		List<?> menus = this.menuService.query("query-level2-menu", params);
		String result = CopyOfTagUtil.createLevelMenu(parentName, menus);
		// 写结果
		out.print(result);
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName
	 *            the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
