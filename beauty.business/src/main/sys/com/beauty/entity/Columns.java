package com.beauty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Columns extends BaseEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String cellType;

	private String className;

	private String data;

	private String columnName;

	private String defaultContent;

	private String name;

	private String type;

	private String title;

	private Integer width;

	private String render;

	private Boolean orderable;

	private Boolean searchable;

	private Boolean visible;

	private String targets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCellType() {
		return cellType;
	}

	public void setCellType(String cellType) {
		this.cellType = cellType == null ? null : cellType.trim();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
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

	public String getDefaultContent() {
		return defaultContent;
	}

	public void setDefaultContent(String defaultContent) {
		this.defaultContent = defaultContent == null ? null : defaultContent.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render == null ? null : render.trim();
	}

	public Boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getTargets() {
		return targets;
	}

	public void setTargets(String targets) {
		this.targets = targets == null ? null : targets.trim();
	}

}