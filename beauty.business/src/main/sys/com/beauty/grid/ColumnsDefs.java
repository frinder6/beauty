package com.beauty.grid;

import java.io.Serializable;

public class ColumnsDefs implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long gridId;

	private String render;

	private String targets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGridId() {
		return gridId;
	}

	public void setGridId(Long gridId) {
		this.gridId = gridId;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render == null ? null : render.trim();
	}

	public String getTargets() {
		return targets;
	}

	public void setTargets(String targets) {
		this.targets = targets == null ? null : targets.trim();
	}
}
