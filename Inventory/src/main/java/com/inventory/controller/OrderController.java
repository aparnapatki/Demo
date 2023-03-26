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

import com.inventory.Response.OrderResponse;
import com.inventory.model.Cart;
import com.inventory.model.Order;
import com.inventory.request.OrderRequest;
import com.inventory.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/getAllOrder")
	public ResponseEntity<List<OrderResponse>> getAllOrder(){
		
		return new ResponseEntity<List<OrderResponse>>(orderService.getAllOrder(),HttpStatus.OK);	
	}
	
	@GetMapping("/getOrderById/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id){
		
		return new ResponseEntity<Order>(orderService.getOrderById(id),HttpStatus.OK);	
	}
	
	@GetMapping("/getOrderByUserId/{id}")
	public ResponseEntity<Order> getCartByUserId(@PathVariable Long id){
		
		return new ResponseEntity<Order>(orderService.getOrderByUserId(id) ,HttpStatus.OK);	
	}
	@PostMapping("/createOrder")
	public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
		return new ResponseEntity<Order>(orderService.createOrder(orderRequest),HttpStatus.CREATED);
		
	}

	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody OrderRequest orderRequest, @PathVariable Long id) {
		return new ResponseEntity<Order>(orderService.updateOrder(orderRequest,id),HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return "deleted successfully";
	}

}
