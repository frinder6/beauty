package com.beauty.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	protected static final long serialVersionUID = 1L;

	@JsonProperty("DT_RowId")
	protected Long DT_RowId;

}
