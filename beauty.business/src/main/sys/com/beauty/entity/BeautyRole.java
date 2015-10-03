package com.beauty.entity;


public class BeautyRole extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public BeautyRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long id;

	private String code;

	private String name;

	private Long groupId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim().toUpperCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}