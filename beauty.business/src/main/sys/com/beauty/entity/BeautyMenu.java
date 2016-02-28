package com.beauty.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeautyMenu extends BaseEntity {
    private static final long serialVersionUID = 8823565583772390072L;
    private Long id;

    /**
     * code取值规则：
     * 1、系统级的以SYS-开头
     * 2、菜单级的以MENU-开头
     * 3、资源级的以RES-开头 优先级依次递减，如
     * ‘系统访问’（资源），命名为：SYS-ACCESS；
     * ‘系统管理访问’（菜单），命名为：MENU-SYS-MNG-ACCESS；
     * ‘新增菜单’（资源），命名为：RES-MENU-ADD；
     */
    private String code;

    private String name;

    private String url;

    private Long parentId;

    private Byte level;

    private Long groupId;

    private List<BeautyMenu> children = new ArrayList<BeautyMenu>();

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<BeautyMenu> getChildren() {
        return children;
    }

    public void setChildren(List<BeautyMenu> children) {
        this.children = children;
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