package com.beauty.entity;


public class BeautyAuthority extends BaseEntity {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public BeautyAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long id;

	/**
	 * code取值规则： 1、系统级的以SYS-开头 2、菜单级的以MENU-开头 3、资源级的以RES-开头 优先级依次递减，如
	 * ‘系统访问’（资源），命名为：SYS-ACCESS； ‘系统管理访问’（菜单），命名为：MENU-SYS-MNG-ACCESS；
	 * ‘新增菜单’（资源），命名为：RES-MENU-ADD；
	 */
	private String code;

	private String name;

	private Long groupId;

	private Byte type;

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

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

}