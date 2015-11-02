package com.beauty.entity;

import java.util.ArrayList;
import java.util.List;

public class BeautyMenu extends BaseEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public BeautyMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long id;

	private String code;

	private String name;

	private String url;

	private Long parentId;

	private Byte level;

	private Long groupId;

	private List<BeautyMenu> children = new ArrayList<BeautyMenu>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim().toUpperCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Byte getLevel() {
		return level;
	}

	public void setLevel(Byte level) {
		this.level = level;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the children
	 */
	public List<BeautyMenu> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<BeautyMenu> children) {
		this.children = children;
	}

}