package com.beauty.model;

import java.io.Serializable;

public class Grid implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private boolean autoWidth = true;
	private boolean deferRender = true;
	private boolean info = true;
	private boolean jQueryUI = false;
	private boolean lengthChange = true;
	private boolean ordering = true;
	private boolean paging = true;
	private boolean processing = true;
	private boolean scrollX = true;
	private String scrollY;
	private boolean searching = true;
	private boolean serverSide = true;
	private boolean stateSave = true;
	private boolean deferLoading = false;
	private boolean destroy = false;
	private int displayStart = 0;
	private String dom = "lfrtip";
	private int[] lengthMenu = { 10, 25, 50 };
	private boolean orderCellsTop = false;
	private boolean orderClasses = true;
	private Object[][] order;
	private boolean orderMulti = false;
	private Object orderFixed;
	private int pageLength = 10;
	private String pagingType = "full";
	private boolean scrollCollapse = false;
	private Search search = new Search();
	private Object[] searchCols;
	private int searchDelay = 0;
	private String renderer;
	private String retrieve;
	private int stateDuration = 0;
	private String stripeClasses;
	private int tabIndex = 0;
	private Columns columns = new Columns();
	private ColumnsDefs columnsDefs = new ColumnsDefs();

	/**
	 * @return the autoWidth
	 */
	public boolean isAutoWidth() {
		return autoWidth;
	}

	/**
	 * @param autoWidth
	 *            the autoWidth to set
	 */
	public void setAutoWidth(boolean autoWidth) {
		this.autoWidth = autoWidth;
	}

	/**
	 * @return the deferRender
	 */
	public boolean isDeferRender() {
		return deferRender;
	}

	/**
	 * @param deferRender
	 *            the deferRender to set
	 */
	public void setDeferRender(boolean deferRender) {
		this.deferRender = deferRender;
	}

	/**
	 * @return the info
	 */
	public boolean isInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(boolean info) {
		this.info = info;
	}

	/**
	 * @return the jQueryUI
	 */
	public boolean isjQueryUI() {
		return jQueryUI;
	}

	/**
	 * @param jQueryUI
	 *            the jQueryUI to set
	 */
	public void setjQueryUI(boolean jQueryUI) {
		this.jQueryUI = jQueryUI;
	}

	/**
	 * @return the lengthChange
	 */
	public boolean isLengthChange() {
		return lengthChange;
	}

	/**
	 * @param lengthChange
	 *            the lengthChange to set
	 */
	public void setLengthChange(boolean lengthChange) {
		this.lengthChange = lengthChange;
	}

	/**
	 * @return the ordering
	 */
	public boolean isOrdering() {
		return ordering;
	}

	/**
	 * @param ordering
	 *            the ordering to set
	 */
	public void setOrdering(boolean ordering) {
		this.ordering = ordering;
	}

	/**
	 * @return the paging
	 */
	public boolean isPaging() {
		return paging;
	}

	/**
	 * @param paging
	 *            the paging to set
	 */
	public void setPaging(boolean paging) {
		this.paging = paging;
	}

	/**
	 * @return the processing
	 */
	public boolean isProcessing() {
		return processing;
	}

	/**
	 * @param processing
	 *            the processing to set
	 */
	public void setProcessing(boolean processing) {
		this.processing = processing;
	}

	/**
	 * @return the scrollX
	 */
	public boolean isScrollX() {
		return scrollX;
	}

	/**
	 * @param scrollX
	 *            the scrollX to set
	 */
	public void setScrollX(boolean scrollX) {
		this.scrollX = scrollX;
	}

	/**
	 * @return the scrollY
	 */
	public String getScrollY() {
		return scrollY;
	}

	/**
	 * @param scrollY
	 *            the scrollY to set
	 */
	public void setScrollY(String scrollY) {
		this.scrollY = scrollY;
	}

	/**
	 * @return the searching
	 */
	public boolean isSearching() {
		return searching;
	}

	/**
	 * @param searching
	 *            the searching to set
	 */
	public void setSearching(boolean searching) {
		this.searching = searching;
	}

	/**
	 * @return the serverSide
	 */
	public boolean isServerSide() {
		return serverSide;
	}

	/**
	 * @param serverSide
	 *            the serverSide to set
	 */
	public void setServerSide(boolean serverSide) {
		this.serverSide = serverSide;
	}

	/**
	 * @return the stateSave
	 */
	public boolean isStateSave() {
		return stateSave;
	}

	/**
	 * @param stateSave
	 *            the stateSave to set
	 */
	public void setStateSave(boolean stateSave) {
		this.stateSave = stateSave;
	}

	/**
	 * @return the deferLoading
	 */
	public boolean isDeferLoading() {
		return deferLoading;
	}

	/**
	 * @param deferLoading
	 *            the deferLoading to set
	 */
	public void setDeferLoading(boolean deferLoading) {
		this.deferLoading = deferLoading;
	}

	/**
	 * @return the destroy
	 */
	public boolean isDestroy() {
		return destroy;
	}

	/**
	 * @param destroy
	 *            the destroy to set
	 */
	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}

	/**
	 * @return the displayStart
	 */
	public int getDisplayStart() {
		return displayStart;
	}

	/**
	 * @param displayStart
	 *            the displayStart to set
	 */
	public void setDisplayStart(int displayStart) {
		this.displayStart = displayStart;
	}

	/**
	 * @return the dom
	 */
	public String getDom() {
		return dom;
	}

	/**
	 * @param dom
	 *            the dom to set
	 */
	public void setDom(String dom) {
		this.dom = dom;
	}

	/**
	 * @return the lengthMenu
	 */
	public int[] getLengthMenu() {
		return lengthMenu;
	}

	/**
	 * @param lengthMenu
	 *            the lengthMenu to set
	 */
	public void setLengthMenu(int[] lengthMenu) {
		this.lengthMenu = lengthMenu;
	}

	/**
	 * @return the orderCellsTop
	 */
	public boolean isOrderCellsTop() {
		return orderCellsTop;
	}

	/**
	 * @param orderCellsTop
	 *            the orderCellsTop to set
	 */
	public void setOrderCellsTop(boolean orderCellsTop) {
		this.orderCellsTop = orderCellsTop;
	}

	/**
	 * @return the orderClasses
	 */
	public boolean isOrderClasses() {
		return orderClasses;
	}

	/**
	 * @param orderClasses
	 *            the orderClasses to set
	 */
	public void setOrderClasses(boolean orderClasses) {
		this.orderClasses = orderClasses;
	}

	/**
	 * @return the order
	 */
	public Object[][] getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Object[][] order) {
		this.order = order;
	}

	/**
	 * @return the orderMulti
	 */
	public boolean isOrderMulti() {
		return orderMulti;
	}

	/**
	 * @param orderMulti
	 *            the orderMulti to set
	 */
	public void setOrderMulti(boolean orderMulti) {
		this.orderMulti = orderMulti;
	}

	/**
	 * @return the orderFixed
	 */
	public Object getOrderFixed() {
		return orderFixed;
	}

	/**
	 * @param orderFixed
	 *            the orderFixed to set
	 */
	public void setOrderFixed(Object orderFixed) {
		this.orderFixed = orderFixed;
	}

	/**
	 * @return the pageLength
	 */
	public int getPageLength() {
		return pageLength;
	}

	/**
	 * @param pageLength
	 *            the pageLength to set
	 */
	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}

	/**
	 * @return the pagingType
	 */
	public String getPagingType() {
		return pagingType;
	}

	/**
	 * @param pagingType
	 *            the pagingType to set
	 */
	public void setPagingType(String pagingType) {
		this.pagingType = pagingType;
	}

	/**
	 * @return the scrollCollapse
	 */
	public boolean isScrollCollapse() {
		return scrollCollapse;
	}

	/**
	 * @param scrollCollapse
	 *            the scrollCollapse to set
	 */
	public void setScrollCollapse(boolean scrollCollapse) {
		this.scrollCollapse = scrollCollapse;
	}

	/**
	 * @return the search
	 */
	public Search getSearch() {
		return search;
	}

	/**
	 * @param search
	 *            the search to set
	 */
	public void setSearch(Search search) {
		this.search = search;
	}

	/**
	 * @return the searchCols
	 */
	public Object[] getSearchCols() {
		return searchCols;
	}

	/**
	 * @param searchCols
	 *            the searchCols to set
	 */
	public void setSearchCols(Object[] searchCols) {
		this.searchCols = searchCols;
	}

	/**
	 * @return the searchDelay
	 */
	public int getSearchDelay() {
		return searchDelay;
	}

	/**
	 * @param searchDelay
	 *            the searchDelay to set
	 */
	public void setSearchDelay(int searchDelay) {
		this.searchDelay = searchDelay;
	}

	/**
	 * @return the renderer
	 */
	public String getRenderer() {
		return renderer;
	}

	/**
	 * @param renderer
	 *            the renderer to set
	 */
	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	/**
	 * @return the retrieve
	 */
	public String getRetrieve() {
		return retrieve;
	}

	/**
	 * @param retrieve
	 *            the retrieve to set
	 */
	public void setRetrieve(String retrieve) {
		this.retrieve = retrieve;
	}

	/**
	 * @return the stateDuration
	 */
	public int getStateDuration() {
		return stateDuration;
	}

	/**
	 * @param stateDuration
	 *            the stateDuration to set
	 */
	public void setStateDuration(int stateDuration) {
		this.stateDuration = stateDuration;
	}

	/**
	 * @return the stripeClasses
	 */
	public String getStripeClasses() {
		return stripeClasses;
	}

	/**
	 * @param stripeClasses
	 *            the stripeClasses to set
	 */
	public void setStripeClasses(String stripeClasses) {
		this.stripeClasses = stripeClasses;
	}

	/**
	 * @return the tabIndex
	 */
	public int getTabIndex() {
		return tabIndex;
	}

	/**
	 * @param tabIndex
	 *            the tabIndex to set
	 */
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	/**
	 * @return the columns
	 */
	public Columns getColumns() {
		return columns;
	}

	/**
	 * @param columns
	 *            the columns to set
	 */
	public void setColumns(Columns columns) {
		this.columns = columns;
	}

	/**
	 * @return the columnsDefs
	 */
	public ColumnsDefs getColumnsDefs() {
		return columnsDefs;
	}

	/**
	 * @param columnsDefs
	 *            the columnsDefs to set
	 */
	public void setColumnsDefs(ColumnsDefs columnsDefs) {
		this.columnsDefs = columnsDefs;
	}

}
