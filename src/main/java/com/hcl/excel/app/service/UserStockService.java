package com.hcl.excel.app.service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;

public interface UserStockService {
	
	public ExcelResponse importDataIntoDB();
	
	public WeeklyUserSpendResponse weeklySpendByUser(WeeklySpentRequest userId);

}
