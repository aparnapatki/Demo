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

import com.inventory.model.OrderItem;
import com.inventory.model.Product;
import com.inventory.request.OrderItemRequest;
import com.inventory.request.ProductRequest;
import com.inventory.service.OrderItemService;


@RestController

public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@GetMapping("/getAllOrderItem")
	public ResponseEntity<List<OrderItem>> getAllOrderItem(){
		
		return new ResponseEntity<List<OrderItem>>(orderItemService.getAllOrderItem(), HttpStatus.OK);	
	}
	@GetMapping("/getOrderItemById/{id}")
	public ResponseEntity<OrderItem> getProductById(@PathVariable Long id){
		
		return new ResponseEntity<OrderItem>(orderItemService.getOrderItemById(id), HttpStatus.OK);	
	}
	@PostMapping("/createOrderItem")
	public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemRequest orderItemRequest) {
		return new ResponseEntity<OrderItem>(orderItemService.createOrderItem(orderItemRequest), HttpStatus.CREATED);
		
	}

	@PutMapping("/updateOrderItem/{id}")
	public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItemRequest orderItemRequest, @PathVariable Long id) {
		return new ResponseEntity<OrderItem>(orderItemService.updateOrderItem(orderItemRequest), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteOrderItem/{id}")
	public String deleteProduct(@PathVariable Long id) {
		orderItemService.deleteProduct(id);
		return "deleted successfully";
	}


}
