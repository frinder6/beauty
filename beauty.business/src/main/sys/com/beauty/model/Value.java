package com.beauty.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Value implements Serializable {

    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    public Value() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Value(String value) {
        super();
        this.value = value;
    }

    public Value(Object data) {
        super();
        this.data = data;
    }

    private String value;

    private Byte type;

    private List<Object> values = new ArrayList<Object>();

    private Object data;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
