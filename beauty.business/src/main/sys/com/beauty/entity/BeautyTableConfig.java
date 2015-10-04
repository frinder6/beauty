package com.beauty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class BeautyTableConfig extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String tableName;

	private String title;

	private String data;

	private String columnName;

	private Boolean orderable;

	private Integer width;

	private String className;

	private Integer sequence;

	private String render;

	public BeautyTableConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeautyTableConfig(String tableName, String columnName) {
		super();
		this.tableName = tableName;
		this.columnName = columnName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim().toUpperCase();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data == null ? null : data.trim();
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}

	public Boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render == null ? null : render.trim();
	}

}