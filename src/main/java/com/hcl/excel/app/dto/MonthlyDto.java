package com.hcl.excel.app.dto;

import java.util.Date;


public class MonthlyDto {

	private Integer transactionId;
	private Integer userId;
	private Integer productId;
	private String productName;
	private Integer quantity;
	private double price;
	private Date createDt;
	private double totalPrice;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "MonthlyDto [transactionId=" + transactionId + ", userId=" + userId + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", createDt="
				+ createDt + ", totalPrice=" + totalPrice + "]";
	}
	public MonthlyDto() {
		
	}
	

}
