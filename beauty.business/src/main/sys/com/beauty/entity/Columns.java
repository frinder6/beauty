package com.beauty.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Columns implements Serializable {

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

	private Byte orderable;

	private Byte searchable;

	private Byte visible;

	private String targets;

	private Integer sequence;

	private Date createTime;

	private String creater;

	private Date lastUpdateTime;

	private String modifier;

	private Byte isDeleted;

	private String def1;

	private String def2;

	private Date def3;

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

	public Byte getOrderable() {
		return orderable;
	}

	public void setOrderable(Byte orderable) {
		this.orderable = orderable;
	}

	public Byte getSearchable() {
		return searchable;
	}

	public void setSearchable(Byte searchable) {
		this.searchable = searchable;
	}

	public Byte getVisible() {
		return visible;
	}

	public void setVisible(Byte visible) {
		this.visible = visible;
	}

	public String getTargets() {
		return targets;
	}

	public void setTargets(String targets) {
		this.targets = targets == null ? null : targets.trim();
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater == null ? null : creater.trim();
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier == null ? null : modifier.trim();
	}

	public Byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDef1() {
		return def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1 == null ? null : def1.trim();
	}

	public String getDef2() {
		return def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2 == null ? null : def2.trim();
	}

	public Date getDef3() {
		return def3;
	}

	public void setDef3(Date def3) {
		this.def3 = def3;
	}
}