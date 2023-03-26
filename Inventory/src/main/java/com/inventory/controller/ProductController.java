package com.inventory.controller;

import java.util.List;
import java.util.Optional;

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

import com.inventory.model.Product;
import com.inventory.model.UserRole;
import com.inventory.request.ProductRequest;
import com.inventory.model.Product;
import com.inventory.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Product>> getAllProduct(){
		
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);	
	}
	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);	
	}
	@PostMapping("/createProduct")
	public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
		return new ResponseEntity<Product>(productService.createProduct(productRequest), HttpStatus.CREATED);
		
	}

	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest productRequest, @PathVariable Long id) {
		return new ResponseEntity<Product>(productService.updateProduct(productRequest, id), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return "deleted successfully";
	}


}
