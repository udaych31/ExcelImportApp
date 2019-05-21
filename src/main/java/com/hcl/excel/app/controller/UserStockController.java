package com.hcl.excel.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;
import com.hcl.excel.app.service.UserStockService;

@RestController
@RequestMapping("/user")
public class UserStockController {
	
	@Autowired
	UserStockService userStockService;

	@GetMapping("/importData")
	private ExcelResponse importDataIntoDB() {
		return null;
	}
	
	@PostMapping("/monthlyusertransaction")
	private MonthlyResponse monthly(@RequestBody MonthlyPojo month) {
		MonthlyResponse response=userStockService.monthly(month);
		return response;
	}
	@PostMapping("/monthlyproductransaction")
	private MonthlyResponse monthlyproduct(@RequestBody MonthlyProductPojo month) {
		MonthlyResponse response=userStockService.monthlyproduct(month);
		return response;
	}

}
