package com.hcl.excel.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.excel.app.dto.ExcelResponse;

@RestController
@RequestMapping("/user")
public class UserStockController {
	
	
	@GetMapping("/importData")
	private ExcelResponse importDataIntoDB() {
		return null;
	}

}
