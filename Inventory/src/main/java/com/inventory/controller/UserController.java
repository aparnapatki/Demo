package com.inventory.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.inventory.model.User;
import com.inventory.model.UserRole;
import com.inventory.repository.UserRepository;
import com.inventory.repository.UserRoleRepository;
import com.inventory.request.UserRequest;
import com.inventory.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		
		return new ResponseEntity<List<User>> (userService.getAllUser(),HttpStatus.OK);	
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);	
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) throws Exception {
		return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
	
		
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long id) {
		return new ResponseEntity<User>(userService.updateUser(userRequest,id), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "deleted successfully";
	}

}
