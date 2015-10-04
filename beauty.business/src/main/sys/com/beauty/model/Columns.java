package com.beauty.model;

import java.io.Serializable;

public class Columns implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String data;
	private String name;
	private String type;
	private String width;
	private String render;
	private boolean orderable;
	private boolean searchable;
	private boolean visible;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the render
	 */
	public String getRender() {
		return render;
	}

	/**
	 * @param render
	 *            the render to set
	 */
	public void setRender(String render) {
		this.render = render;
	}

	/**
	 * @return the orderable
	 */
	public boolean isOrderable() {
		return orderable;
	}

	/**
	 * @param orderable
	 *            the orderable to set
	 */
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

	/**
	 * @return the searchable
	 */
	public boolean isSearchable() {
		return searchable;
	}

	/**
	 * @param searchable
	 *            the searchable to set
	 */
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @param visible
	 *            the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
