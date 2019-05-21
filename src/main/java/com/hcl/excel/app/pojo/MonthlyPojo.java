package com.hcl.excel.app.pojo;

public class MonthlyPojo {

	private Integer month;
	private Integer userId;
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "MonthlyPojo [month=" + month + ", userId=" + userId + "]";
	}
	
}
