package com.hcl.excel.app.service;

import com.hcl.excel.app.dto.DateRangeRequest;
import com.hcl.excel.app.dto.DateRangeResponse;
import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;

import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserResponse;

import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;

public interface UserStockService {

	public ExcelResponse importDataIntoDB();

	public MonthlyResponse monthly(MonthlyPojo month);

	public MonthlyResponse monthlyProduct(MonthlyProductPojo month);
	public UserResponse getUsers();

	public ResultResponse dailyReport(Integer userId);

	public WeeklyUserSpendResponse weeklySpendByUser(WeeklySpentRequest userId);
	
	public DateRangeResponse getUserSpentsWithinRange(DateRangeRequest request);

}
