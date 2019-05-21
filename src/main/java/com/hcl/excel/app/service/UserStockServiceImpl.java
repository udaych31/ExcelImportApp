package com.hcl.excel.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.excel.app.dto.ExcelResponse;
import com.hcl.excel.app.dto.ResultDto;
import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserDto;
import com.hcl.excel.app.dto.UserResponse;

import com.hcl.excel.app.repository.UserRepository;

@Service
public class UserStockServiceImpl implements UserStockService {

	 @Autowired
	 UserRepository userRepository;
	
	@Override
	public ExcelResponse importDataIntoDB() {
		return null;
	}


	@Override
	public UserResponse getUsers() {
		
		UserResponse response=null;		
		List<UserDto>  usersdto=null;
		try {
			response=new UserResponse();
			usersdto=new ArrayList<UserDto>();
		   List<Object[]> users=(List<Object[]>) userRepository.findUsers();
		
		for(Object[] user:users) {
			UserDto userdto=new UserDto();
			userdto.setUserId((Integer)(user[0]));
			usersdto.add(userdto);
			}
		response.setUsers(usersdto);
		
		}
		catch(Exception e) {
			
		}
		return response;
	}


	@SuppressWarnings("deprecation")
	@Override
	public ResultResponse dailyReport(Integer userId) {
		
		ResultResponse response=new ResultResponse();
		
		List<ResultDto>  dtos=new ArrayList<ResultDto>();
		List<Object[]>  details   = (List<Object[]>) userRepository.findDayBaseResut(userId);
		
		for(Object[] res:details) {
			
			ResultDto dto=new ResultDto();
			dto.setCreateDate((Date)res[0]);
			dto.setProductId((Integer)res[1]);
			dto.setProductName((String)(res[2]));
			dto.setSumOfTotalPrice((Double)(res[3]));
			dtos.add(dto);
			
			
			
		}
		
		response.setResults(dtos);
		
	
		
		return response;
	}

}
