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

import com.inventory.model.Cart;
import com.inventory.request.CartRequest;
import com.inventory.service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@GetMapping("/getAllCart")
	public ResponseEntity<List<Cart>> getAllCart(){
		
		return new ResponseEntity<List<Cart>>(cartService.getAllCart(),HttpStatus.OK);	
	}

	@GetMapping("/getCartById/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Long id){
		
		return new ResponseEntity<Cart>(cartService.getCartById(id) ,HttpStatus.OK);	
	}
	
	@GetMapping("/getCartByUserId/{id}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable Long id){
		
		return new ResponseEntity<Cart>(cartService.getCartByUserId(id) ,HttpStatus.OK);	
	}
	@PostMapping("/createCart")
	public ResponseEntity<Cart> createCart(@RequestBody CartRequest cartRequest) throws Exception {
		return new ResponseEntity<Cart>(cartService.createCart(cartRequest) ,HttpStatus.CREATED);
		
	}

	@PutMapping("/updateCart/{id}")
	public ResponseEntity<Cart> updateCart(@RequestBody CartRequest cartRequest, @PathVariable Long id) {
		return new ResponseEntity<Cart>(cartService.updateCart(cartRequest, id) ,HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteCart/{id}")
	public String deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
		return "deleted successfully";
	}


}
