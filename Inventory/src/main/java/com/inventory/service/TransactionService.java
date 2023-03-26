package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Order;
import com.inventory.model.OrderItem;
import com.inventory.model.Transaction;
import com.inventory.repository.OrderRepository;
import com.inventory.repository.TransactionRepository;
import com.inventory.request.OrderItemRequest;
import com.inventory.request.TransactionRequest;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Transaction getTransactionById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction createTransaction(TransactionRequest transactionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction updateTransaction(TransactionRequest transactionRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteTransaction(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
