package com.hcl.excel.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.util.ExcelImportToDB;

@Service
public class UserStockServiceImpl implements UserStockService {
	
	private static final Logger logger=LogManager.getLogger(UserStockServiceImpl.class);
	
	
	@Autowired
	private ExcelImportToDB excelImport;

	@Override
	public ExcelResponse importDataIntoDB() {
		logger.info("inside service");
		return excelImport.loadDataToDB();
	}

}
