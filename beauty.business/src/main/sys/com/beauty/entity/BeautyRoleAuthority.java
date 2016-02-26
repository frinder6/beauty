package com.beauty.entity;

public class BeautyRoleAuthority extends BaseEntity {
    private static final long serialVersionUID = -7306738371030901761L;
    private Long id;

    private Long roleId;

    private Long authorityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }
}