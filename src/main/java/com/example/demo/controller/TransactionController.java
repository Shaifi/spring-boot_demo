package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StatisticsDTO;
import com.example.demo.dto.TransactionDTO;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping(value="rest")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@ResponseBody
	@RequestMapping(value="/transaction",method=RequestMethod.POST)
	public ResponseEntity addTransaction(HttpServletRequest request, @RequestBody TransactionDTO transactionDTO) {
		ResponseEntity response;
		try {
			transactionService.createTransaction(transactionDTO);
			response = new ResponseEntity(HttpStatus.CREATED);
		}catch(Exception e){
			response = new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/statistics",method=RequestMethod.GET)
	public ResponseEntity<StatisticsDTO> getStatistics() {
		StatisticsDTO statisticsDTO;
		ResponseEntity response; 
		try {
			statisticsDTO = transactionService.getStatistics();
			response = new ResponseEntity(statisticsDTO,HttpStatus.OK);
		}catch(Exception e) {
			response = new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
