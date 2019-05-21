package com.hcl.excel.app.service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;

public interface UserStockService {
	
	public ExcelResponse importDataIntoDB();

	public MonthlyResponse monthly(MonthlyPojo month);

	public MonthlyResponse monthlyproduct(MonthlyProductPojo month);

}
