package com.hcl.excel.app.dto;

import java.util.List;

public class MonthlyResponse {

	private List<MonthlyDto> monthlyDto;
	private String message;
	private Double totalMonthSpend;
	
	public Double getTotalMonthSpend() {
		return totalMonthSpend;
	}
	public void setTotalMonthSpend(Double totalMonthSpend) {
		this.totalMonthSpend = totalMonthSpend;
	}
	public List<MonthlyDto> getMonthlyDto() {
		return monthlyDto;
	}
	public void setMonthlyDto(List<MonthlyDto> monthlyDto) {
		this.monthlyDto = monthlyDto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "MonthlyResponse [monthlyDto=" + monthlyDto + ", message=" + message + ", totalMonthSpend="
				+ totalMonthSpend + "]";
	}
	public MonthlyResponse() {
		super();
	}
	
}
