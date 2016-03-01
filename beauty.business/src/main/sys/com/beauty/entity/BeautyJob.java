package com.beauty.entity;

import java.util.Date;

public class BeautyJob extends BaseEntity {

    private static final long serialVersionUID = -7236453098190322941L;

    private Long id;

    private String name;

    private String groupName;

    private String classPath;

    private String methodName;

    private String cronExpression;

    private Byte status;

    private String remark;

    private Date createTime;

    private String creater;

    private Date lastUpdateTime;

    private String modifier;

    private Byte isDeleted;

    private String def1;

    private String def2;

    private Date def3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

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