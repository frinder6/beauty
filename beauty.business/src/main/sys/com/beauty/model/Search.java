package com.beauty.model;

import java.io.Serializable;

public class Search implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String search;
	private boolean caseInsensitive = true;
	private boolean regex = false;
	private boolean smart = true;

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search
	 *            the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @return the caseInsensitive
	 */
	public boolean isCaseInsensitive() {
		return caseInsensitive;
	}

	/**
	 * @param caseInsensitive
	 *            the caseInsensitive to set
	 */
	public void setCaseInsensitive(boolean caseInsensitive) {
		this.caseInsensitive = caseInsensitive;
	}

	/**
	 * @return the regex
	 */
	public boolean isRegex() {
		return regex;
	}

	/**
	 * @param regex
	 *            the regex to set
	 */
	public void setRegex(boolean regex) {
		this.regex = regex;
	}

	/**
	 * @return the smart
	 */
	public boolean isSmart() {
		return smart;
	}

	/**
	 * @param smart
	 *            the smart to set
	 */
	public void setSmart(boolean smart) {
		this.smart = smart;
	}

}
