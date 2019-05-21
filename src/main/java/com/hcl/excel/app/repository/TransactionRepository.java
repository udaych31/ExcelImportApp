package com.hcl.excel.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.excel.app.entity.Transaction;



@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	
	public List<?> findWeeklySpend(@Param(value = "userId") Integer userId,@Param(value="noOfWeeks") Integer noOfWeeks);
	

}
