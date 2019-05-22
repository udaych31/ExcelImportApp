package com.hcl.excel.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.excel.app.dto.ResultResponse;
import com.hcl.excel.app.dto.UserResponse;
import com.hcl.excel.app.repository.UserRepository;



@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
	
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserStockServiceImpl serviceImpl;
	
	@Test
	public void testGetUsers() {
	
	  Integer[] obj=new Integer[2];
	  
	  obj[0]=1;
	  obj[1]=2;
	
	 List<Integer> list=new ArrayList();
	
	 list.add(1);
	 
	
	
	  Mockito.when(userRepository.findUsers()).thenReturn(list);
		
	  UserResponse response=serviceImpl.getUsers();
	  System.out.println(response.getUsers());
	 Assert.assertEquals(obj[0], response.getUsers().get(0).getUserId());
		
	
	}
	
	
	@Test
	public void testDailyReport() {
		
		
		  Object[] obj=new Object[4];
		  
		  obj[0]=new Date();;
		  obj[1]=2;
		  obj[2]="laptop";
		  obj[3]=100.0;
		
		 List list=new ArrayList();
		
		 list.add(obj);
		 
		
		
		  Mockito.when(userRepository.findDayBaseResut(1)).thenReturn(list);
			
		  ResultResponse response=serviceImpl.dailyReport(1);
		  
		 Assert.assertEquals(obj[0], response.getResults().get(0).getCreateDate());
			
		
		
		
	}
	
	
	
	


}
