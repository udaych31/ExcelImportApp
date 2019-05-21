package com.hcl.excel.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION_DETAILS")
@NamedQuery(name = "Transaction.findWeeklySpend",query="select sum(t.totalPrice),t.userId from Transaction t where t.userId=:userId and t.createDt > CURRENT_DATE- :noOfWeeks  ")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	
	@Column
	private Integer userId;
	
	@Column
	private Integer productId;
	
	@Column
	private String productName;
	
	@Column
	private Integer quantity;
	
	@Column
	private double price;
	
	@Column
	private double totalPrice;
	
	@Column
	private Date createDt;
	
	public Transaction() {
		super();
	}

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
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=");
		builder.append(transactionId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", createDt=");
		builder.append(createDt);
		builder.append("]");
		return builder.toString();
	}

	

}
