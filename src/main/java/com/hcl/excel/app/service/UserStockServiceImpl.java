package com.hcl.excel.app.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.DateRangeRequest;
import com.hcl.excel.app.dto.DateRangeResponse;
import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyDto;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.dto.ResultDto;
import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserDto;
import com.hcl.excel.app.dto.UserResponse;
import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;
import com.hcl.excel.app.entity.Transaction;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;
import com.hcl.excel.app.repository.TransactionRepository;
import com.hcl.excel.app.repository.UserRepository;
import com.hcl.excel.app.util.ExcelImportToDB;

@Service
public class UserStockServiceImpl implements UserStockService {

	private static final Logger logger = LogManager.getLogger(UserStockServiceImpl.class);

	@Autowired
	private ExcelImportToDB excelImport;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ExcelResponse importDataIntoDB() {
		logger.info("inside service");
		return excelImport.loadDataToDB();
	}

	@Override
	public WeeklyUserSpendResponse weeklySpendByUser(WeeklySpentRequest request) {
		WeeklyUserSpendResponse response = null;

		try {

			response = new WeeklyUserSpendResponse();
			Integer noOfWeeks = request.getNoOfWeeks() * 7;
			List<Object[]> obj = transactionRepository.findWeeklySpend(request.getUserId(), noOfWeeks);
			response = new WeeklyUserSpendResponse();
			if(!obj.isEmpty()) {
				if(obj.get(0)[0]!=null) {
					response.setTotalPrice((double)obj.get(0)[0]);
				}
				response.setUserId(request.getUserId());
			} 


		} catch (Exception e) {
			logger.error(this.getClass().getName() + " weeklySpendByUser :: " + e.getMessage());
		}
		return response;
	}

	@Override
	public UserResponse getUsers() {

		UserResponse response = null;
		List<UserDto> usersdto = null;
		try {
			response = new UserResponse();
			usersdto = new ArrayList<UserDto>();
			List<Integer> users =  userRepository.findUsers();

			for (Integer user : users) {
				UserDto userdto = new UserDto();
				userdto.setUserId((Integer) (user));
				usersdto.add(userdto);
			}
			response.setUsers(usersdto);

		} catch (Exception e) {

		}
		return response;
	}

	
	@Override
	public ResultResponse dailyReport(Integer userId) {

		ResultResponse response = new ResultResponse();

		List<ResultDto> dtos = new ArrayList<ResultDto>();
		List<Object[]> details = (List<Object[]>) userRepository.findDayBaseResut(userId);

		for (Object[] res : details) {

			ResultDto dto = new ResultDto();

			Date date = (Date) res[0];
			
			SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
			String value = date1.format(date);

			dto.setCreateDate(value);
			dto.setProductId((Integer) res[1]);
			dto.setProductName((String) (res[2]));
			dto.setSumOfTotalPrice((Double) (res[3]));
			dtos.add(dto);

		}

		response.setResults(dtos);

		return response;
	}

	@Override
	public MonthlyResponse monthly(MonthlyPojo month) {

		List<Transaction> result = transactionRepository.getMonthly(month.getMonth(), month.getUserId());
		MonthlyResponse monthlyResponse = new MonthlyResponse();
		ArrayList<MonthlyDto> ar = new ArrayList<MonthlyDto>();
		Double d = (double) 0;
		for (Transaction transaction : result) {
			
			MonthlyDto monthlyDto=new MonthlyDto();

			monthlyDto.setTransactionId(transaction.getTransactionId());
			monthlyDto.setProductId(transaction.getProductId());
			monthlyDto.setUserId(transaction.getUserId());
			monthlyDto.setCreateDt(transaction.getCreateDt());
			monthlyDto.setProductName(transaction.getProductName());
			monthlyDto.setPrice(transaction.getPrice());
			monthlyDto.setQuantity(transaction.getQuantity());
			monthlyDto.setTotalPrice(transaction.getTotalPrice());
			d = d + monthlyDto.getTotalPrice();
			ar.add(monthlyDto);

		}
		monthlyResponse.setMonthlyDto(ar);
		monthlyResponse.setMessage("200");
		monthlyResponse.setTotalMonthSpend(d);
		return monthlyResponse;
	}
	


	public MonthlyResponse monthlyProduct(MonthlyProductPojo month) {
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
				return monthlyResponse;
	}
	
	@Override
	public DateRangeResponse getUserSpentsWithinRange(DateRangeRequest request) {
		DateRangeResponse response=null;
		try {
			if(request!=null) {
				response=new DateRangeResponse();
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				logger.info(request.getFromDate());
				Date fromDt = sdf.parse(request.getFromDate());
				Date toDate = sdf.parse(request.getToDate());
				
				logger.info(fromDt);
				logger.info(toDate);
				
				Double dateRange = transactionRepository.dateRange(fromDt, toDate,request.getUserId());
				if(dateRange!=null) {
					response.setUserId(request.getUserId());
					response.setFromDate(request.getFromDate());
					response.setToDate(request.getToDate());
					response.setTotalSpent(dateRange);
				}else {
					response.setUserId(request.getUserId());
					response.setFromDate(request.getFromDate());
					response.setToDate(request.getToDate());
				}
			}
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" - getUserSpentsWithinRange : "+e.getMessage());
		}
		
		return response;
	}

}
