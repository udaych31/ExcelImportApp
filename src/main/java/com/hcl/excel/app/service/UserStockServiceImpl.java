package com.hcl.excel.app.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;
import com.hcl.excel.app.repository.TransactionRepository;
import com.hcl.excel.app.util.ExcelImportToDB;

@Service
public class UserStockServiceImpl implements UserStockService {
	
	private static final Logger logger=LogManager.getLogger(UserStockServiceImpl.class);
	
	
	@Autowired
	private ExcelImportToDB excelImport;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public ExcelResponse importDataIntoDB() {
		logger.info("inside service");
		return excelImport.loadDataToDB();
	}
	
	@Override
	public WeeklyUserSpendResponse weeklySpendByUser(WeeklySpentRequest request) {
		WeeklyUserSpendResponse response=null;
		
		try {
			response=new WeeklyUserSpendResponse();
			Integer noOfWeeks = request.getNoOfWeeks();
			List<Object[]> obj = (List<Object[]>) transactionRepository.findWeeklySpend(request.getUserId(),noOfWeeks*7);
			response=new WeeklyUserSpendResponse();
			response.setTotalPrice((double)obj.get(0)[0]);
			response.setUserId(((Integer)obj.get(0)[1]));
			
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" weeklySpendByUser :: "+e.getMessage());
		}
		return response;
	}

}
