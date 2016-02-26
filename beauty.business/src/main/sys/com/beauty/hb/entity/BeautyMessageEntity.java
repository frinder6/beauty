package com.beauty.hb.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Entity
@Table(name = "beauty_message", schema = "", catalog = "beauty")
public class BeautyMessageEntity {
    private long id;
    private String messageHead;
    private String messageBody;
    private byte status;
    private String remark;
    private Timestamp createTime;
    private String creater;
    private Timestamp lastUpdateTime;
    private String modifier;
    private byte isDeleted;
    private String def1;
    private String def2;
    private Timestamp def3;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message_head")
    public String getMessageHead() {
        return messageHead;
    }

    public void setMessageHead(String messageHead) {
        this.messageHead = messageHead;
    }

    @Basic
    @Column(name = "message_body")
    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "creater")
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    @Basic
    @Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "modifier")
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Basic
    @Column(name = "is_deleted")
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "def1")
    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    @Basic
    @Column(name = "def2")
    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    @Basic
    @Column(name = "def3")
    public Timestamp getDef3() {
        return def3;
    }

    public void setDef3(Timestamp def3) {
        this.def3 = def3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeautyMessageEntity that = (BeautyMessageEntity) o;

        if (id != that.id) return false;
        if (isDeleted != that.isDeleted) return false;
        if (status != that.status) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null) return false;
        if (def1 != null ? !def1.equals(that.def1) : that.def1 != null) return false;
        if (def2 != null ? !def2.equals(that.def2) : that.def2 != null) return false;
        if (def3 != null ? !def3.equals(that.def3) : that.def3 != null) return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (messageBody != null ? !messageBody.equals(that.messageBody) : that.messageBody != null) return false;
        if (messageHead != null ? !messageHead.equals(that.messageHead) : that.messageHead != null) return false;
        if (modifier != null ? !modifier.equals(that.modifier) : that.modifier != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (messageHead != null ? messageHead.hashCode() : 0);
        result = 31 * result + (messageBody != null ? messageBody.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (creater != null ? creater.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        result = 31 * result + (modifier != null ? modifier.hashCode() : 0);
        result = 31 * result + (int) isDeleted;
        result = 31 * result + (def1 != null ? def1.hashCode() : 0);
        result = 31 * result + (def2 != null ? def2.hashCode() : 0);
        result = 31 * result + (def3 != null ? def3.hashCode() : 0);
        return result;
    }
}
