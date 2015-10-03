package com.beauty.entity;

public class BeautyAuthorityResource extends BaseReEntity {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long authorityId;

	private Long resourceId;

	private Byte type;

	public BeautyAuthorityResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeautyAuthorityResource(Long authorityId, Long resourceId) {
		super();
		this.authorityId = authorityId;
		this.resourceId = resourceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the type
	 */
	public Byte getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Byte type) {
		this.type = type;
	}

}