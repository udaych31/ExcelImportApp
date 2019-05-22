package com.hcl.excel.app.dto;

import java.io.Serializable;

public class DateRangeResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String fromDate;
	
	private String toDate;
	
	private double totalSpent;
	
	public DateRangeResponse() {
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

	public double getTotalSpent() {
		return totalSpent;
	}

	public void setTotalSpent(double totalSpent) {
		this.totalSpent = totalSpent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DateRangeResponse [userId=");
		builder.append(userId);
		builder.append(", fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append(", totalSpent=");
		builder.append(totalSpent);
		builder.append("]");
		return builder.toString();
	}
	
	

}
