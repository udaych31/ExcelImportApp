package com.hcl.excel.app.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.excel.app.entity.Transaction;

@Repository
public interface UserRepository extends JpaRepository<Transaction, Integer>{
	
	  @Query("select DISTINCT c.userId from Transaction c")     
	  List<?>   findUsers();
	  
	  
	  @Query("select c.createDt,c.productId,c.productName,SUM(totalPrice) from Transaction c where c.userId=:userId"
		  		+ " group by c.createDt")
		  List<?> findDayBaseResut(@Param("userId") Integer userId);
}
