package com.beauty.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	protected static final long serialVersionUID = 1L;

	@JsonProperty("DT_RowId")
	private Long DT_RowId;

	protected Long groupId;
	protected String remark;
	protected Date createTime;
	protected String creater;
	protected Date lastUpdateTime;
	protected String modifier;
	protected Byte isDeleted;
	protected String def1;
	protected String def2;
	protected Date def3;

	/**
	 * @return the dT_RowId
	 */
	@Transient
	public Long getDT_RowId() {
		return DT_RowId;
	}

	/**
	 * @param dT_RowId
	 *            the dT_RowId to set
	 */
	public void setDT_RowId(Long dT_RowId) {
		DT_RowId = dT_RowId;
	}

	@Column(name = "group_id", nullable = false)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "remark", nullable = false, length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false, length = 19, updatable = false)
	public Date getCreateTime() {
		this.createTime = new Date();
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creater", nullable = false, length = 50, updatable = false, insertable = false)
	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time", nullable = false, length = 19)
	public Date getLastUpdateTime() {
		this.lastUpdateTime = new Date();
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "modifier", nullable = false, length = 50, updatable = false, insertable = false)
	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Column(name = "is_deleted", nullable = false, updatable = false, insertable = false)
	public Byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "def1", nullable = false, length = 50, updatable = false, insertable = false)
	public String getDef1() {
		return this.def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	@Column(name = "def2", nullable = false, length = 50, updatable = false, insertable = false)
	public String getDef2() {
		return this.def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "def3", nullable = false, length = 19, updatable = false, insertable = false)
	public Date getDef3() {
		return this.def3;
	}

	public void setDef3(Date def3) {
		this.def3 = def3;
	}
}
