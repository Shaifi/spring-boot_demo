package com.example.demo.service;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StatisticsDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.persistence.model.Transaction;
import com.example.demo.persistence.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository repTransaction;
	
	@Transactional(rollbackOn = Exception.class)
	public void createTransaction(TransactionDTO transactionDTO) {
		
		Transaction transaction = new Transaction();
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setTimestamp(transactionDTO.getTimestamp());
		repTransaction.save(transaction);
	}
	
	
	public StatisticsDTO getStatistics() {
		List<Object[]> ob = repTransaction.getStatistics(System.currentTimeMillis()-60000);
		Object[] obj = ob.get(0);
		return new StatisticsDTO((Double)obj[0],(Double)obj[1],(Double)obj[2],(Double)obj[3],((BigInteger)obj[4]).longValue());
	}
}
