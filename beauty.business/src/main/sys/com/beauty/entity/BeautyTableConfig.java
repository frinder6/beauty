package com.beauty.entity;

// Generated 2015-8-11 20:04:10 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.beauty.annotation.Orderable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * BeautyTableConfig generated by hbm2java
 */
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "beauty_table_config", catalog = "beauty")
public class BeautyTableConfig implements java.io.Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	@Orderable(columnName = "table_name")
	private String tableName;
	@Orderable(columnName = "title")
	private String title;
	@Orderable(columnName = "data")
	private String data;
	@Orderable(columnName = "column_name")
	private String columnName;
	@Orderable(columnName = "orderable")
	private Byte orderable;
	@Orderable(columnName = "width")
	private Integer width;
	@Orderable(columnName = "class_name")
	private String className;
	@Orderable(columnName = "sequence")
	private Integer sequence;
	private String render;
	private String remark;
	private Date createTime;
	private String creater;
	private Date lastUpdateTime;
	private String modifier;
	private Byte isDeleted;
	private String def1;
	private String def2;
	private Date def3;

	public BeautyTableConfig() {
	}

	public BeautyTableConfig(String tableName, String columnName, Byte orderable, Integer width, Integer sequence, String remark, Date createTime, Date lastUpdateTime) {
		super();
		this.tableName = tableName;
		this.columnName = columnName;
		this.orderable = orderable;
		this.width = width;
		this.sequence = sequence;
		this.remark = remark;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	public BeautyTableConfig(String tableName, String title, String data, String columnName, Byte orderable, Integer width, String className, Integer sequence, String render, String remark, Date createTime, String creater, Date lastUpdateTime, String modifier, Byte isDeleted, String def1, String def2, Date def3) {
		this.tableName = tableName;
		this.title = title;
		this.data = data;
		this.columnName = columnName;
		this.orderable = orderable;
		this.width = width;
		this.className = className;
		this.sequence = sequence;
		this.render = render;
		this.remark = remark;
		this.createTime = createTime;
		this.creater = creater;
		this.lastUpdateTime = lastUpdateTime;
		this.modifier = modifier;
		this.isDeleted = isDeleted;
		this.def1 = def1;
		this.def2 = def2;
		this.def3 = def3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "table_name", nullable = false, length = 50)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "title", nullable = false, length = 50, insertable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "data", nullable = false, length = 50, insertable = false)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "column_name", nullable = false, length = 50)
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Column(name = "orderable", nullable = false)
	public Byte getOrderable() {
		return this.orderable;
	}

	public void setOrderable(Byte orderable) {
		this.orderable = orderable;
	}

	@Column(name = "width", nullable = false)
	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	@Column(name = "class_name", nullable = false, length = 50, insertable = false)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "sequence", nullable = false)
	public Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Column(name = "render", nullable = false, length = 100, insertable = false)
	public String getRender() {
		return this.render;
	}

	public void setRender(String render) {
		this.render = render;
	}

	@Column(name = "remark", nullable = false, length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creater", nullable = false, length = 50, insertable = false)
	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", nullable = false, length = 19)
	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "modifier", nullable = false, length = 50, insertable = false)
	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Column(name = "is_deleted", nullable = false, insertable = false)
	public Byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "def1", nullable = false, length = 50, insertable = false)
	public String getDef1() {
		return this.def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	@Column(name = "def2", nullable = false, length = 50, insertable = false)
	public String getDef2() {
		return this.def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "def3", nullable = false, length = 19, insertable = false)
	public Date getDef3() {
		return this.def3;
	}

	public void setDef3(Date def3) {
		this.def3 = def3;
	}

}
