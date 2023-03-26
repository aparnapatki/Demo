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

import com.inventory.model.CartItem;
import com.inventory.request.CartItemRequest;
import com.inventory.service.CartItemService;

@RestController
public class CartItemController {

	@Autowired
	CartItemService cartItemService;
	
	@GetMapping("/getAllCartItem")
	public ResponseEntity<List<CartItem>> getAllCartItem(){
		
		return new ResponseEntity<List<CartItem>>(cartItemService.getAllCartItem(),HttpStatus.OK);	
	}

	@GetMapping("/getCartItemById/{id}")
	public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id){
		
		return new ResponseEntity<CartItem>(cartItemService.getCartItemById(id) ,HttpStatus.OK);	
	}
	@PostMapping("/createCartItem")
	public ResponseEntity<CartItem> createCartItem(@RequestBody CartItemRequest cartItemRequest) {
		return new ResponseEntity<CartItem>(cartItemService.createCartItem(cartItemRequest) ,HttpStatus.CREATED);
		
	}

	@PutMapping("/updateCartItem/{id}")
	public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItemRequest cartItemRequest, @PathVariable Long id) {
		return new ResponseEntity<CartItem>(cartItemService.updateCartItem(cartItemRequest, id) ,HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteCartItem/{id}")
	public String deleteCartItem(@PathVariable Long id) {
		cartItemService.deleteCartItem(id);
		return "deleted successfully";
	}


}
