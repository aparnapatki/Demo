package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Transaction;
import com.inventory.request.TransactionRequest;
import com.inventory.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/getAllTransaction")
	public ResponseEntity<List<Transaction>> getAllTransaction(){
		
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransaction(), HttpStatus.OK);	
	}
	@GetMapping("/getTransactionById/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id){
		
		return new ResponseEntity<Transaction>(TransactionService.getTransactionById(id), HttpStatus.OK);	
	}
	@PostMapping("/createTransaction")
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionRequest TransactionRequest) {
		return new ResponseEntity<Transaction>(transactionService.createTransaction(TransactionRequest), HttpStatus.CREATED);
		
	}

	@PutMapping("/updateTransaction/{id}")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody TransactionRequest TransactionRequest, @PathVariable Long id) {
		return new ResponseEntity<Transaction>(transactionService.updateTransaction(TransactionRequest), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteTransaction/{id}")
	public String deleteTransaction(@PathVariable Long id) {
		transactionService.deleteTransaction(id);
		return "deleted successfully";
	}


}
