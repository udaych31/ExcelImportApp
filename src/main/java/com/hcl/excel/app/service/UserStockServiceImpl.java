package com.hcl.excel.app.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.MonthlyDto;
import com.hcl.excel.app.dto.MonthlyResponse;
import com.hcl.excel.app.entity.Transaction;
import com.hcl.excel.app.pojo.MonthlyPojo;
import com.hcl.excel.app.pojo.MonthlyProductPojo;
import com.hcl.excel.app.repository.TransactionRepository;
import com.hcl.excel.app.dto.ResultDto;
import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserDto;
import com.hcl.excel.app.dto.UserResponse;
import com.hcl.excel.app.dto.WeeklySpentRequest;
import com.hcl.excel.app.dto.WeeklyUserSpendResponse;
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
			response=new WeeklyUserSpendResponse();
			Integer noOfWeeks = request.getNoOfWeeks()*7;
			List<Object[]> obj = (List<Object[]>) transactionRepository.findWeeklySpend(request.getUserId(),noOfWeeks);
			response=new WeeklyUserSpendResponse();
			response.setTotalPrice((Integer)obj.get(0)[0]);
			response.setUserId(((Integer)obj.get(0)[1]));

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
			List<Integer> users = (List<Integer>) userRepository.findUsers();

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

	@SuppressWarnings("deprecation")
	@Override
	public ResultResponse dailyReport(Integer userId) {

		ResultResponse response = new ResultResponse();

		List<ResultDto> dtos = new ArrayList<ResultDto>();
		List<Object[]> details = (List<Object[]>) userRepository.findDayBaseResut(userId);

		for (Object[] res : details) {

			ResultDto dto = new ResultDto();
			dto.setCreateDate((Date) res[0]);
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
