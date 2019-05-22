package com.hcl.excel.app.dto;

import java.util.Date;

public class ResultDto {

	private String createDate;
	private String productName;
	private Double sumOfTotalPrice;
	private Integer productId;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getSumOfTotalPrice() {
		return sumOfTotalPrice;
	}

	public void setSumOfTotalPrice(Double sumOfTotalPrice) {
		this.sumOfTotalPrice = sumOfTotalPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
