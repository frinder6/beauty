package com.beauty.entity;

import com.beauty.annotation.Orderable;

public class BeautyResource extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@Orderable(columnName = "code")
	private String code;

	@Orderable(columnName = "name")
	private String name;

	@Orderable(columnName = "url")
	private String url;

	private Long groupId;

	public BeautyResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeautyResource(String url) {
		super();
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}