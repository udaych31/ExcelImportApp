package com.hcl.excel.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.excel.app.dto.ExcelResponse;

import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserResponse;
import com.hcl.excel.app.service.UserStockService;

import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;
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
	private UserResponse getUsers() {

		UserResponse response = userStockService.getUsers();

		return response;

	}

	@GetMapping("/getDailyBaseReport")
	private ResultResponse getDailyBaseReport(@RequestParam Integer userid) {

		ResultResponse response = userStockService.dailyReport(userid);
		return response;

	}

}
