package com.example.demo.persistence.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StatisticsDTO;
import com.example.demo.persistence.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	//public List<Transaction> findByIdOrderByTimestampDesc(int id);
	
	@Query(
			value = "SELECT"
					+ " sum(t.amount) AS sum,avg(t.amount) AS avg,max(t.amount) AS max,min(t.amount) AS min,count(t.amount) AS count from transaction t where t.timestamp>:lastTime", 
			nativeQuery = true
			)
		List<Object[]> getStatistics(@Param("lastTime") Long lastTime);
	

}





