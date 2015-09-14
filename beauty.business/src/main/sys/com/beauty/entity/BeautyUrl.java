package com.beauty.entity;

import com.beauty.annotation.Orderable;

public class BeautyUrl extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@Orderable(columnName = "url")
	private String url;

	public BeautyUrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeautyUrl(String url, String remark) {
		super();
		this.url = url;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

}