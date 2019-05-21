package com.hcl.excel.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;
import com.hcl.excel.app.repository.TransactionRepository;
import com.hcl.excel.app.util.ExcelImportToDB;

@RunWith(MockitoJUnitRunner.class)
public class UserStockServiceImplTest {
	
	private static final Logger logger=LogManager.getLogger(UserStockServiceImpl.class);
	
	
	@InjectMocks
	private UserStockServiceImpl userStockServiceImpl;
	
	@Mock
	private ExcelImportToDB excel;
	
	@Mock
	private TransactionRepository transactionRepository;

	
	@Test
	public void importDataIntoDB() {
		logger.info("inside service");
		ExcelResponse response=new ExcelResponse();
		response.setMessage("success");
		
		when(excel.loadDataToDB()).thenReturn(response);
		ExcelResponse importDataIntoDB = userStockServiceImpl.importDataIntoDB();
		assertEquals("success", importDataIntoDB.getMessage());
		
	}
	
	@Test
	public void findWeeklySpent() {
		WeeklySpentRequest request=new  WeeklySpentRequest();
		request.setNoOfWeeks(1);
		request.setUserId(1);
		List<Object[]> list=new ArrayList<>();
		Object[] obj=new Object[2];
		obj[0]=48783;
		obj[1]=1;
		list.add(obj);
		when(transactionRepository.findWeeklySpend(1,7)).thenReturn(list);
		
		WeeklyUserSpendResponse weeklySpendByUser = userStockServiceImpl.weeklySpendByUser(request);
		
		assertEquals(weeklySpendByUser.getTotalPrice(), list.get(0)[0]);
		
	}
	
	

}
