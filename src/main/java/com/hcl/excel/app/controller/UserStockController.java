package com.hcl.excel.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.service.UserStockServiceImpl;

@RestController
@RequestMapping("/user")
public class UserStockController {
	
	
	@Autowired
	private UserStockServiceImpl userStockServiceImpl;
	
	
	@GetMapping("/importData")
	private ExcelResponse importDataIntoDB() {
		return userStockServiceImpl.importDataIntoDB();
	}

}
