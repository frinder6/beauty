package com.beauty.entity;

import com.beauty.annotation.Orderable;

public class BeautyAuthorityResource {

	private Long id;

	private Long authorityId;

	private Long resourceId;

	@Orderable(columnName = "code")
	private String code;

	@Orderable(columnName = "name")
	private String name;

	@Orderable(columnName = "url")
	private String url;

	public BeautyAuthorityResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeautyAuthorityResource(Long authorityId, Long resourceId) {
		super();
		this.authorityId = authorityId;
		this.resourceId = resourceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}