package com.hcl.excel.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.excel.app.dto.DateRangeRequest;
import com.hcl.excel.app.dto.DateRangeResponse;
import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;
import com.hcl.excel.app.service.UserStockService;
import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserResponse;
import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;
import com.hcl.excel.app.service.UserStockService;
import com.hcl.excel.app.service.UserStockServiceImpl;

@RestController
@RequestMapping("/user")
public class UserStockController {	

	@Autowired
	UserStockService userStockService;

	@Autowired
	private UserStockServiceImpl userStockServiceImpl;

	@GetMapping("/importData")
	public ExcelResponse importDataIntoDB() {
		return userStockServiceImpl.importDataIntoDB();
	}

	@PostMapping("/getweeklyspent")
	public WeeklyUserSpendResponse findUserWeeklySpend(WeeklySpentRequest request) {
		return userStockServiceImpl.weeklySpendByUser(request);
	}

	@GetMapping("/getUsers")
	public UserResponse getUsers() {

		UserResponse response = userStockService.getUsers();

		return response;

	}

	@GetMapping("/getDailyBaseReport")
	public ResultResponse getDailyBaseReport(@RequestParam Integer userid) {

		ResultResponse response = userStockService.dailyReport(userid);
		return response;

	}
	
	@PostMapping("/monthlyusertransaction")
	public MonthlyResponse monthly(@RequestBody MonthlyPojo month) {
		MonthlyResponse response=userStockService.monthly(month);
		return response;
	}
	@PostMapping("/monthlyproductransaction")
	public MonthlyResponse monthlyproduct(@RequestBody MonthlyProductPojo month) {
		MonthlyResponse response=userStockService.monthlyProduct(month);
		return response;
	}
	
	@PostMapping("/daterange")
	public DateRangeResponse getUserSpentsWithinDates(DateRangeRequest request) {
		DateRangeResponse dateRange = userStockServiceImpl.getUserSpentsWithinRange(request);
		System.out.println(dateRange.toString());
		return dateRange;
	}
	

}
