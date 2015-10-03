package com.beauty.entity;

import java.io.Serializable;

import com.beauty.annotation.Orderable;

public class BaseReEntity implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Orderable(columnName = "code")
	protected String code;

	@Orderable(columnName = "name")
	protected String name;

	@Orderable(columnName = "url")
	protected String url;

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
