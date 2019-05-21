package com.hcl.excel.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyDto;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.entity.Transaction;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;
import com.hcl.excel.app.repository.TransactionRepository;

@Service
public class UserStockServiceImpl implements UserStockService {

	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public ExcelResponse importDataIntoDB() {
		return null;
	}

	@Override
	public MonthlyResponse monthly(MonthlyPojo month) {
		// TODO Auto-generated method stub
		List<Transaction> result=transactionRepository.getMonthly(month.getMonth(), month.getUserId());
		MonthlyResponse monthlyResponse=new MonthlyResponse();
		ArrayList<MonthlyDto> ar=new ArrayList<MonthlyDto>();
		Double d=(double) 0;
		for(Transaction transaction:result)
		{
			
			MonthlyDto monthlyDto=new MonthlyDto();
			monthlyDto.setTransactionId(transaction.getTransactionId());
			monthlyDto.setProductId(transaction.getProductId());
			monthlyDto.setUserId(transaction.getUserId());
			monthlyDto.setCreateDt(transaction.getCreateDt());
			monthlyDto.setProductName(transaction.getProductName());
			monthlyDto.setPrice(transaction.getPrice());
			monthlyDto.setQuantity(transaction.getQuantity());
			monthlyDto.setTotalPrice(transaction.getTotalPrice());
			d=d+monthlyDto.getTotalPrice();
			ar.add(monthlyDto);
			
					}
		monthlyResponse.setMonthlyDto(ar);
		monthlyResponse.setMessage("200");
		monthlyResponse.setTotalMonthSpend(d);
		System.out.println(result);
		return monthlyResponse;
	}

	@Override
	public MonthlyResponse monthlyproduct(MonthlyProductPojo month) {
		// TODO Auto-generated method stub
				List<Transaction> result=transactionRepository.getMonthlyProductHistory(month.getMonth(), month.getProductId());
				MonthlyResponse monthlyResponse=new MonthlyResponse();
				ArrayList<MonthlyDto> ar=new ArrayList<MonthlyDto>();
				Double d=(double) 0;
				for(Transaction transaction:result)
				{
					
					MonthlyDto monthlyDto=new MonthlyDto();
					monthlyDto.setTransactionId(transaction.getTransactionId());
					monthlyDto.setProductId(transaction.getProductId());
					monthlyDto.setUserId(transaction.getUserId());
					monthlyDto.setCreateDt(transaction.getCreateDt());
					monthlyDto.setProductName(transaction.getProductName());
					monthlyDto.setPrice(transaction.getPrice());
					monthlyDto.setQuantity(transaction.getQuantity());
					monthlyDto.setTotalPrice(transaction.getTotalPrice());
					d=d+monthlyDto.getTotalPrice();
					ar.add(monthlyDto);
					
							}
				monthlyResponse.setMonthlyDto(ar);
				monthlyResponse.setMessage("200");
				monthlyResponse.setTotalMonthSpend(d);
				System.out.println(result);
				return monthlyResponse;
	}

}
