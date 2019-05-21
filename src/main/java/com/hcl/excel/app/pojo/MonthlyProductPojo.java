package com.hcl.excel.app.pojo;

public class MonthlyProductPojo {

	private Integer month;
	private Integer productId;
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "MonthlyProductPojo [month=" + month + ", productId=" + productId + "]";
	}
	
}
