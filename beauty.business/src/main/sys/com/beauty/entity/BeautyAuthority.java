package com.beauty.entity;

// Generated 2015-7-25 16:15:27 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BeautyAuthority generated by hbm2java
 */
@Entity
@Table(name = "beauty_authority", catalog = "beauty")
public class BeautyAuthority implements java.io.Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String code;
	private String name;
	private long groupId;
	private byte type;
	private String remark;
	private Date createTime;
	private String creater;
	private Date lastUpdateTime;
	private String modifier;
	private byte isDeleted;
	private String def1;
	private String def2;
	private Date def3;

	public BeautyAuthority() {
	}

	public BeautyAuthority(String code, String name, long groupId, byte type, String remark, Date createTime, String creater, Date lastUpdateTime, String modifier, byte isDeleted, String def1, String def2, Date def3) {
		this.code = code;
		this.name = name;
		this.groupId = groupId;
		this.type = type;
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

	@Column(name = "code", nullable = false, length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "group_id", nullable = false)
	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "type", nullable = false)
	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
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

	@Column(name = "creater", nullable = false, length = 50)
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

	@Column(name = "modifier", nullable = false, length = 50)
	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Column(name = "is_deleted", nullable = false)
	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "def1", nullable = false, length = 50)
	public String getDef1() {
		return this.def1;
	}

	public void setDef1(String def1) {
		this.def1 = def1;
	}

	@Column(name = "def2", nullable = false, length = 50)
	public String getDef2() {
		return this.def2;
	}

	public void setDef2(String def2) {
		this.def2 = def2;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "def3", nullable = false, length = 19)
	public Date getDef3() {
		return this.def3;
	}

	public void setDef3(Date def3) {
		this.def3 = def3;
	}

}