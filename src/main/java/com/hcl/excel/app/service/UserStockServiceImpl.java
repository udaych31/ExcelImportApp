package com.hcl.excel.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.ExcelResponse;
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
			List<Object[]> users = (List<Object[]>) userRepository.findUsers();

			for (Object[] user : users) {
				UserDto userdto = new UserDto();
				userdto.setUserId((Integer) (user[0]));
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

}
