package com.beauty.hb.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by frinder_liu on 2016/2/26.
 */
@Entity
@javax.persistence.Table(name = "beauty_table_columns", schema = "", catalog = "beauty")
public class BeautyTableColumnsEntity {
    private long id;

    @Id
    @javax.persistence.Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long columnId;

    @Basic
    @javax.persistence.Column(name = "column_id")
    public long getColumnId() {
        return columnId;
    }

    public void setColumnId(long columnId) {
        this.columnId = columnId;
    }

    private String tableName;

    @Basic
    @javax.persistence.Column(name = "table_name")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private String cellType;

    @Basic
    @javax.persistence.Column(name = "cell_type")
    public String getCellType() {
        return cellType;
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
    }

    private String className;

    @Basic
    @javax.persistence.Column(name = "class_name")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    private String data;

    @Basic
    @javax.persistence.Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String columnName;

    @Basic
    @javax.persistence.Column(name = "column_name")
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    private String defaultContent;

    @Basic
    @javax.persistence.Column(name = "default_content")
    public String getDefaultContent() {
        return defaultContent;
    }

    public void setDefaultContent(String defaultContent) {
        this.defaultContent = defaultContent;
    }

    private String name;

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String type;

    @Basic
    @javax.persistence.Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String title;

    @Basic
    @javax.persistence.Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int width;

    @Basic
    @javax.persistence.Column(name = "width")
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private String render;

    @Basic
    @javax.persistence.Column(name = "render")
    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }

    private byte orderable;

    @Basic
    @javax.persistence.Column(name = "orderable")
    public byte getOrderable() {
        return orderable;
    }

    public void setOrderable(byte orderable) {
        this.orderable = orderable;
    }

    private byte searchable;

    @Basic
    @javax.persistence.Column(name = "searchable")
    public byte getSearchable() {
        return searchable;
    }

    public void setSearchable(byte searchable) {
        this.searchable = searchable;
    }

    private byte visible;

    @Basic
    @javax.persistence.Column(name = "visible")
    public byte getVisible() {
        return visible;
    }

    public void setVisible(byte visible) {
        this.visible = visible;
    }

    private byte editable;

    @Basic
    @javax.persistence.Column(name = "editable")
    public byte getEditable() {
        return editable;
    }

    public void setEditable(byte editable) {
        this.editable = editable;
    }

    private String targets;

    @Basic
    @javax.persistence.Column(name = "targets")
    public String getTargets() {
        return targets;
    }

    public void setTargets(String targets) {
        this.targets = targets;
    }

    private int sequence;

    @Basic
    @javax.persistence.Column(name = "sequence")
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    private String remark;

    @Basic
    @javax.persistence.Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private Timestamp createTime;

    @Basic
    @javax.persistence.Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    private String creater;

    @Basic
    @javax.persistence.Column(name = "creater")
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    private Timestamp lastUpdateTime;

    @Basic
    @javax.persistence.Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    private String modifier;

    @Basic
    @javax.persistence.Column(name = "modifier")
    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    private byte isDeleted;

    @Basic
    @javax.persistence.Column(name = "is_deleted")
    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    private String def1;

    @Basic
    @javax.persistence.Column(name = "def1")
    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    private String def2;

    @Basic
    @javax.persistence.Column(name = "def2")
    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    private Timestamp def3;

    @Basic
    @javax.persistence.Column(name = "def3")
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

        BeautyTableColumnsEntity that = (BeautyTableColumnsEntity) o;

        if (columnId != that.columnId) return false;
        if (editable != that.editable) return false;
        if (id != that.id) return false;
        if (isDeleted != that.isDeleted) return false;
        if (orderable != that.orderable) return false;
        if (searchable != that.searchable) return false;
        if (sequence != that.sequence) return false;
        if (visible != that.visible) return false;
        if (width != that.width) return false;
        if (cellType != null ? !cellType.equals(that.cellType) : that.cellType != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (def1 != null ? !def1.equals(that.def1) : that.def1 != null) return false;
        if (def2 != null ? !def2.equals(that.def2) : that.def2 != null) return false;
        if (def3 != null ? !def3.equals(that.def3) : that.def3 != null) return false;
        if (defaultContent != null ? !defaultContent.equals(that.defaultContent) : that.defaultContent != null)
            return false;
        if (lastUpdateTime != null ? !lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime != null)
            return false;
        if (modifier != null ? !modifier.equals(that.modifier) : that.modifier != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (render != null ? !render.equals(that.render) : that.render != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (targets != null ? !targets.equals(that.targets) : that.targets != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (columnId ^ (columnId >>> 32));
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (cellType != null ? cellType.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (defaultContent != null ? defaultContent.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + width;
        result = 31 * result + (render != null ? render.hashCode() : 0);
        result = 31 * result + (int) orderable;
        result = 31 * result + (int) searchable;
        result = 31 * result + (int) visible;
        result = 31 * result + (int) editable;
        result = 31 * result + (targets != null ? targets.hashCode() : 0);
        result = 31 * result + sequence;
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
