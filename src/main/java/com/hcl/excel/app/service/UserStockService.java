package com.hcl.excel.app.service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserResponse;

public interface UserStockService {
	
	public ExcelResponse importDataIntoDB();
	
	public UserResponse getUsers();
	
	public ResultResponse dailyReport(Integer userId);

}
