package com.hcl.excel.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.excel.app.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query("from Transaction where month(createDt)=:date AND userId=:user")
	public List<Transaction> getMonthly(@Param("date") Integer date,@Param("user") Integer user);

	@Query("from Transaction where month(createDt)=:date AND productId=:product")
	public List<Transaction> getMonthlyProductHistory(@Param("date") Integer date,@Param("product") Integer product);
	
}
