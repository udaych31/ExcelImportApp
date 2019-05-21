package com.hcl.excel.app.dto;

import java.io.Serializable;


public class WeeklyUserSpendResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	
	private Integer totalPrice;
	
	public WeeklyUserSpendResponse() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeeklyUserSpendResponse [userId=");
		builder.append(userId);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append("]");
		return builder.toString();
	}
	

}
