package com.hcl.excel.app.dto;

import java.io.Serializable;

public class WeeklySpentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	
	private Integer noOfWeeks;
	
	public WeeklySpentRequest() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNoOfWeeks() {
		return noOfWeeks;
	}

	public void setNoOfWeeks(Integer noOfWeeks) {
		this.noOfWeeks = noOfWeeks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeeklySpentRequest [userId=");
		builder.append(userId);
		builder.append(", noOfWeeks=");
		builder.append(noOfWeeks);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
