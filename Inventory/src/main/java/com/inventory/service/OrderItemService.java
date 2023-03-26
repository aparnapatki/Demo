package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Order;
import com.inventory.model.OrderItem;
import com.inventory.repository.OrderRepository;
import com.inventory.request.OrderItemRequest;

@Service
public class OrderItemService {

	@Autowired
	OrderRepository orderRepository;

	public List<OrderItem> getAllOrderItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderItem getOrderItemById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderItem createOrderItem(OrderItemRequest orderItemRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderItem updateOrderItem(OrderItemRequest orderItemRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
