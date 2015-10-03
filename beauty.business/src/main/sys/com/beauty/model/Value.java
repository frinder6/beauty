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

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the values
	 */
	public List<Object> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(List<Object> values) {
		this.values = values;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
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
