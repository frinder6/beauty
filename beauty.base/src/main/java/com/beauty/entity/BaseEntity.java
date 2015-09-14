package com.beauty.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	protected static final long serialVersionUID = 1L;

	@JsonProperty("DT_RowId")
	protected Long DT_RowId;

	protected String remark;

	protected Date createTime;

	protected String creater;

	protected Date lastUpdateTime;

	protected String modifier;

	protected Byte isDeleted;

	protected String def1;

	protected String def2;

	protected Date def3;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
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
