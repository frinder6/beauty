package com.beauty.entity;

import org.apache.commons.codec.digest.DigestUtils;

public class BeautyResource extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String code;

	private String name;

	private String url;

	private Long groupId;

	public BeautyResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeautyResource(String url) {
		super();
		this.url = url;
		this.code = DigestUtils.md5Hex(url.trim()).toUpperCase();
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