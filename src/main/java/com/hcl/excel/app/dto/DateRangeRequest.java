package com.hcl.excel.app.dto;

import java.io.Serializable;
import java.util.Date;

public class DateRangeRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer userId;
	
	private String fromDate;
	
	private String toDate;
	
	public DateRangeRequest() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DateRangeRequest [userId=");
		builder.append(userId);
		builder.append(", fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append("]");
		return builder.toString();
	}
	

}
