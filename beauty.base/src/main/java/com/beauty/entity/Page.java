package com.beauty.entity;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.beauty.util.DatatablesUtil;
import com.beauty.util.StringUtil;

public class Page implements Serializable {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	// 请求数
	private String draw = "0";
	// 起始值
	private String start = "0";
	// 步长
	private String length = "10";
	// 记录数
	private String recordsTotal = "0";
	// 过滤后记录数
	private String recordsFiltered = "";
	// 排序
	private String orderDir = "asc";
	// 排序字段索引
	private String orderIndex = "0";
	// 排序字段
	private String orderColumn = "id";
	// 搜索值
	private String searchValue;

	private Object data;

	/**
	 * 
	 * @Title: getInstance
	 * @Description: TODO(初始化)
	 * @author frinder_liu
	 * @param request
	 * @return
	 * @return Page
	 * @date 2015年8月2日 下午2:58:08
	 * @throws
	 */
	public void init(HttpServletRequest request) {
		this.draw = StringUtil.isNull(request.getParameter("draw"), this.draw);
		this.start = StringUtil.isNull(request.getParameter("start"), this.start);
		this.length = StringUtil.isNull(request.getParameter("length"), this.length);
		this.orderDir = StringUtil.isNull(request.getParameter("order[0][dir]"), this.orderDir);
		this.orderIndex = StringUtil.isNull(request.getParameter("order[0][column]"), this.orderIndex);
		this.searchValue = StringUtil.isNull(request.getParameter("search[value]"), this.searchValue);
		String template = "columns[%s][data]";
		this.orderColumn = StringUtil.isNull(request.getParameter(String.format(template, orderIndex)), this.orderColumn);
	}

	/**
	 * 
	 * @Title: pageToMap
	 * @Description: TODO(将page值设置到map中)
	 * @author frinder_liu
	 * @param params
	 * @return void
	 * @date 2015年8月14日 下午10:39:08
	 * @throws
	 */
	public void pageToMap(Class<?> clazz, Map<String, Object> params) {
		params.put("orderColumn", DatatablesUtil.getColumn(clazz, this.getOrderColumn()));
		params.put("orderDir", this.getOrderDir());
		params.put("searchValue", this.getSearchValue());
		params.put("from", Integer.parseInt(this.getStart()));
		params.put("size", Integer.parseInt(this.getLength()));
	}

	/**
	 * 
	 * @Title: getResult
	 * @Description: TODO(返回结果)
	 * @author frinder_liu
	 * @param data
	 * @param recordsTotal
	 * @param recordsFiltered
	 * @return
	 * @return Page
	 * @date 2015年8月2日 下午2:58:20
	 * @throws
	 */
	public void setResult(Object data, String recordsTotal, String recordsFiltered) {
		this.data = data;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * @return the draw
	 */
	public String getDraw() {
		if (null == draw || draw.length() == 0) {
			return "0";
		}
		return draw;
	}

	/**
	 * @param draw
	 *            the draw to set
	 */
	public void setDraw(String draw) {
		this.draw = draw;
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		if (null == start || start.length() == 0) {
			return "0";
		}
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the length
	 */
	public String getLength() {
		if (null == length || length.length() == 0) {
			return "10";
		}
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * @return the recordsTotal
	 */
	public String getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordsTotal
	 *            the recordsTotal to set
	 */
	public void setRecordsTotal(String recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	/**
	 * @return the recordsFiltered
	 */
	public String getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * @param recordsFiltered
	 *            the recordsFiltered to set
	 */
	public void setRecordsFiltered(String recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * @return the orderDir
	 */
	public String getOrderDir() {
		return orderDir;
	}

	/**
	 * @param orderDir
	 *            the orderDir to set
	 */
	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	/**
	 * @return the orderColumn
	 */
	public String getOrderColumn() {
		return orderColumn;
	}

	/**
	 * @param orderColumn
	 *            the orderColumn to set
	 */
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	/**
	 * @return the searchValue
	 */
	public String getSearchValue() {
		return searchValue;
	}

	/**
	 * @param searchValue
	 *            the searchValue to set
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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
	 * @return the orderIndex
	 */
	public String getOrderIndex() {
		return orderIndex;
	}

	/**
	 * @param orderIndex
	 *            the orderIndex to set
	 */
	public void setOrderIndex(String orderIndex) {
		this.orderIndex = orderIndex;
	}

}
