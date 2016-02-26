package com.beauty.hb.entity;

import javax.persistence.*;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Entity
@Table(name = "beauty_authority_resource", schema = "", catalog = "beauty")
public class BeautyAuthorityResourceEntity {
    private long id;
    private long authorityId;
    private long resourceId;
    private byte type;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "authority_id")
    public long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(long authorityId) {
        this.authorityId = authorityId;
    }

    @Basic
    @Column(name = "resource_id")
    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeautyAuthorityResourceEntity that = (BeautyAuthorityResourceEntity) o;

        if (authorityId != that.authorityId) return false;
        if (id != that.id) return false;
        if (resourceId != that.resourceId) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (authorityId ^ (authorityId >>> 32));
        result = 31 * result + (int) (resourceId ^ (resourceId >>> 32));
        result = 31 * result + (int) type;
        return result;
    }
}
