package com.hcl.excel.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserResponse;
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
	
	@GetMapping("/getUsers")
	private UserResponse getUsers() {
		
		 UserResponse response=userStockService.getUsers();
		 
		 return response;
		 
	}
	
	@GetMapping("/getDailyBaseReport")
	private ResultResponse getDailyBaseReport(@RequestParam Integer userid) {
		
		
		  ResultResponse response=userStockService.dailyReport(userid);
		  return response;
		
	}

}
