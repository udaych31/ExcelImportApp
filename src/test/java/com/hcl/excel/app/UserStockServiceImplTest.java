
package com.hcl.excel.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.excel.app.dto.MonthlyDto;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.entity.Transaction;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;
import com.hcl.excel.app.repository.TransactionRepository;
import com.hcl.excel.app.service.UserStockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserStockServiceImplTest {

	@InjectMocks
	UserStockServiceImpl userStockServiceImpl;

	@Mock
	TransactionRepository userStockRepository;

	@Test
	public void testPartIdsLists() {

		Transaction tr = new Transaction();

		@SuppressWarnings("deprecation")
		Date dt = new Date();
		tr.setCreateDt(dt);
		tr.setPrice(1);
		tr.setProductId(1);
		tr.setProductName("paabn");
		tr.setQuantity(1);
		tr.setTotalPrice(100);
		tr.setTransactionId(1);
		tr.setUserId(1);
		List<Transaction> list = new ArrayList<Transaction>();
		list.add(tr);
		Mockito.when(userStockRepository.getMonthly(4, 1)).thenReturn(list);
		MonthlyPojo pojo = new MonthlyPojo();
		pojo.setMonth(4);
		pojo.setUserId(1);
		MonthlyResponse response = userStockServiceImpl.monthly(pojo);
		;
		MonthlyDto dto = new MonthlyDto();
		dto.setCreateDt(dt);
		dto.setPrice(1);
		dto.setProductId(1);
		dto.setProductName("paabn");
		dto.setQuantity(1);
		dto.setTotalPrice(100);
		dto.setTransactionId(1);
		dto.setUserId(1);
		List<MonthlyDto> monthlyDto = new ArrayList<MonthlyDto>();
		MonthlyResponse res = new MonthlyResponse();
		monthlyDto.add(dto);
		res.setMonthlyDto(monthlyDto);
		res.setMessage("200");
		res.setTotalMonthSpend(100.0);
		assertEquals(response.toString(), res.toString());
	}
	
	
	
	
	public void testMonthlyProduct() {

		Transaction tr = new Transaction();

		@SuppressWarnings("deprecation")
		Date dt = new Date();
		tr.setCreateDt(dt);
		tr.setPrice(1);
		tr.setProductId(1);
		tr.setProductName("paabn");
		tr.setQuantity(1);
		tr.setTotalPrice(100);
		tr.setTransactionId(1);
		tr.setUserId(1);
		List<Transaction> list = new ArrayList<Transaction>();
		list.add(tr);
		Mockito.when(userStockRepository.getMonthly(4, 1)).thenReturn(list);
		MonthlyProductPojo pojo = new MonthlyProductPojo();
		pojo.setMonth(4);
		pojo.setProductId(1);
		MonthlyResponse response = userStockServiceImpl.monthlyProduct(pojo);		
		MonthlyDto dto = new MonthlyDto();
		dto.setCreateDt(dt);
		dto.setPrice(1);
		dto.setProductId(1);
		dto.setProductName("paabn");
		dto.setQuantity(1);
		dto.setTotalPrice(100);
		dto.setTransactionId(1);
		dto.setUserId(1);
		List<MonthlyDto> monthlyDto = new ArrayList<MonthlyDto>();
		MonthlyResponse res = new MonthlyResponse();
		monthlyDto.add(dto);
		res.setMonthlyDto(monthlyDto);
		res.setMessage("200");
		res.setTotalMonthSpend(100.0);
		assertEquals(response.toString(), res.toString());
	}


}
