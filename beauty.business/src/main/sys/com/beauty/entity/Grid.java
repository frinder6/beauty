package com.beauty.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Grid implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String gridName;

	private Byte autoWidth;

	private Byte deferRender;

	private Byte info;

	private Byte jQueryUi;

	private Byte lengthChange;

	private Byte ordering;

	private Byte paging;

	private Byte processing;

	private Byte scrollX;

	private String scrollY;

	private Byte searching;

	private Byte serverSide;

	private Byte stateSave;

	private Byte deferLoading;

	private Byte destory;

	private Integer displayStart;

	private String dom;

	private String lengthMenu;

	private Byte orderCellsTop;

	private Byte orderClasses;

	private String order;

	private Byte orderMulti;

	private String orderFixed;

	private Integer pageLength;

	private Byte scrollCollapse;

	private String searchCols;

	private Integer searchDelay;

	private String renderer;

	private String retrieve;

	private Integer stateDuration;

	private String stripeClasses;

	private Integer tabIndex;

	private Date createTime;

	private String creater;

	private Date lastUpdateTime;

	private String modifier;

	private Byte isDeleted;

	private String def1;

	private String def2;

	private Date def3;

	private List<Columns> columns = new ArrayList<Columns>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName == null ? null : gridName.trim();
	}

	public Byte getAutoWidth() {
		return autoWidth;
	}

	public void setAutoWidth(Byte autoWidth) {
		this.autoWidth = autoWidth;
	}

	public Byte getDeferRender() {
		return deferRender;
	}

	public void setDeferRender(Byte deferRender) {
		this.deferRender = deferRender;
	}

	public Byte getInfo() {
		return info;
	}

	public void setInfo(Byte info) {
		this.info = info;
	}

	public Byte getjQueryUi() {
		return jQueryUi;
	}

	public void setjQueryUi(Byte jQueryUi) {
		this.jQueryUi = jQueryUi;
	}

	public Byte getLengthChange() {
		return lengthChange;
	}

	public void setLengthChange(Byte lengthChange) {
		this.lengthChange = lengthChange;
	}

	public Byte getOrdering() {
		return ordering;
	}

	public void setOrdering(Byte ordering) {
		this.ordering = ordering;
	}

	public Byte getPaging() {
		return paging;
	}

	public void setPaging(Byte paging) {
		this.paging = paging;
	}

	public Byte getProcessing() {
		return processing;
	}

	public void setProcessing(Byte processing) {
		this.processing = processing;
	}

	public Byte getScrollX() {
		return scrollX;
	}

	public void setScrollX(Byte scrollX) {
		this.scrollX = scrollX;
	}

	public String getScrollY() {
		return scrollY;
	}

	public void setScrollY(String scrollY) {
		this.scrollY = scrollY == null ? null : scrollY.trim();
	}

	public Byte getSearching() {
		return searching;
	}

	public void setSearching(Byte searching) {
		this.searching = searching;
	}

	public Byte getServerSide() {
		return serverSide;
	}

	public void setServerSide(Byte serverSide) {
		this.serverSide = serverSide;
	}

	public Byte getStateSave() {
		return stateSave;
	}

	public void setStateSave(Byte stateSave) {
		this.stateSave = stateSave;
	}

	public Byte getDeferLoading() {
		return deferLoading;
	}

	public void setDeferLoading(Byte deferLoading) {
		this.deferLoading = deferLoading;
	}

	public Byte getDestory() {
		return destory;
	}

	public void setDestory(Byte destory) {
		this.destory = destory;
	}

	public Integer getDisplayStart() {
		return displayStart;
	}

	public void setDisplayStart(Integer displayStart) {
		this.displayStart = displayStart;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom == null ? null : dom.trim();
	}

	public String getLengthMenu() {
		return lengthMenu;
	}

	public void setLengthMenu(String lengthMenu) {
		this.lengthMenu = lengthMenu == null ? null : lengthMenu.trim();
	}

	public Byte getOrderCellsTop() {
		return orderCellsTop;
	}

	public void setOrderCellsTop(Byte orderCellsTop) {
		this.orderCellsTop = orderCellsTop;
	}

	public Byte getOrderClasses() {
		return orderClasses;
	}

	public void setOrderClasses(Byte orderClasses) {
		this.orderClasses = orderClasses;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order == null ? null : order.trim();
	}

	public Byte getOrderMulti() {
		return orderMulti;
	}

	public void setOrderMulti(Byte orderMulti) {
		this.orderMulti = orderMulti;
	}

	public String getOrderFixed() {
		return orderFixed;
	}

	public void setOrderFixed(String orderFixed) {
		this.orderFixed = orderFixed == null ? null : orderFixed.trim();
	}

	public Integer getPageLength() {
		return pageLength;
	}

	public void setPageLength(Integer pageLength) {
		this.pageLength = pageLength;
	}

	public Byte getScrollCollapse() {
		return scrollCollapse;
	}

	public void setScrollCollapse(Byte scrollCollapse) {
		this.scrollCollapse = scrollCollapse;
	}

	public String getSearchCols() {
		return searchCols;
	}

	public void setSearchCols(String searchCols) {
		this.searchCols = searchCols == null ? null : searchCols.trim();
	}

	public Integer getSearchDelay() {
		return searchDelay;
	}

	public void setSearchDelay(Integer searchDelay) {
		this.searchDelay = searchDelay;
	}

	public String getRenderer() {
		return renderer;
	}

	public void setRenderer(String renderer) {
		this.renderer = renderer == null ? null : renderer.trim();
	}

	public String getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(String retrieve) {
		this.retrieve = retrieve == null ? null : retrieve.trim();
	}

	public Integer getStateDuration() {
		return stateDuration;
	}

	public void setStateDuration(Integer stateDuration) {
		this.stateDuration = stateDuration;
	}

	public String getStripeClasses() {
		return stripeClasses;
	}

	public void setStripeClasses(String stripeClasses) {
		this.stripeClasses = stripeClasses == null ? null : stripeClasses.trim();
	}

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
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

	public List<Columns> getColumns() {
		return columns;
	}

	public void setColumns(List<Columns> columns) {
		this.columns = columns;
	}

}