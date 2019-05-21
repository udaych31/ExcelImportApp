package com.hcl.excel.app.dto;

import java.io.Serializable;

public class ExcelResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ExcelResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExcelResponse [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
	

}
