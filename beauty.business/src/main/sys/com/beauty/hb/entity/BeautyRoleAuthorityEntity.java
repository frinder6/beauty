package com.beauty.hb.entity;

import javax.persistence.*;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Entity
@Table(name = "beauty_role_authority", schema = "", catalog = "beauty")
public class BeautyRoleAuthorityEntity {
    private long id;
    private long roleId;
    private long authorityId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "authority_id")
    public long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(long authorityId) {
        this.authorityId = authorityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeautyRoleAuthorityEntity that = (BeautyRoleAuthorityEntity) o;

        if (authorityId != that.authorityId) return false;
        if (id != that.id) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (int) (authorityId ^ (authorityId >>> 32));
        return result;
    }
}
