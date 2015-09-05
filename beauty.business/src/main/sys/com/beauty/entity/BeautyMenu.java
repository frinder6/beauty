package com.beauty.entity;

// Generated 2015-7-25 16:15:27 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.beauty.annotation.Orderable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * BeautyMenu generated by hbm2java
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "children" })
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "beauty_menu", catalog = "beauty")
public class BeautyMenu implements java.io.Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	@Orderable(columnName = "code")
	private String code;
	@Orderable(columnName = "name")
	private String name;
	@Orderable(columnName = "url")
	private String url;
	private long parentId;
	private byte level;
	private long groupId;
	@Orderable(columnName = "remark")
	private String remark;
	private Date createTime;
	private String creater;
	private Date lastUpdateTime;
	private String modifier;
	private byte isDeleted;
	private String def1;
	private String def2;
	private Date def3;

	private List<BeautyMenu> children = new ArrayList<BeautyMenu>();

	public BeautyMenu() {
	}

	public BeautyMenu(String code, String name, String url, long parentId, byte level, long groupId, String remark, Date createTime, String creater, Date lastUpdateTime, String modifier, byte isDeleted, String def1, String def2, Date def3) {
		this.code = code;
		this.name = name;
		this.url = url;
		this.parentId = parentId;
		this.level = level;
		this.groupId = groupId;
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

	public void reset(String searchValue) {
		this.code = searchValue;
		this.name = searchValue;
		this.url = searchValue;
		this.remark = searchValue;
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
		return this.code == null ? null : this.code.toUpperCase();
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

	@Column(name = "url", nullable = false, length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "parent_id", nullable = false)
	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "level", nullable = false, updatable = false, insertable = false)
	public byte getLevel() {
		return this.level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	@Column(name = "group_id", nullable = false, updatable = false, insertable = false)
	public long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
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
	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
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

	/**
	 * @return the children
	 */
	@Transient
	public List<BeautyMenu> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<BeautyMenu> children) {
		this.children = children;
	}

}
