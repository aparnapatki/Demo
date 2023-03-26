package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.Response.UserRoleResponse;
import com.inventory.exception.UserNotExistsException;
import com.inventory.model.UserRole;
import com.inventory.request.UserRoleRequest;
import com.inventory.service.UserRoleService;

@RestController
public class UserRoleController {
	
	@Autowired
	UserRoleService userRoleService;
	
	@GetMapping("/getAllUserRole")
	public ResponseEntity<List<UserRoleResponse>> getAllUserRole(){
		
		return new ResponseEntity<List<UserRoleResponse>>(userRoleService.getAllUserRole(),HttpStatus.OK);	
	}
	
	@GetMapping("/getUserRoleById/{id}")
	public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id){
		
		return new ResponseEntity<UserRole>(userRoleService.getUserRoleById(id), HttpStatus.OK);	
	}
	@PostMapping("/createUserRole")
	public ResponseEntity<UserRole> createUserRole(@Valid @RequestBody UserRoleRequest userRoleRequest) {
		return new ResponseEntity<UserRole>(userRoleService.createUserRole(userRoleRequest),HttpStatus.CREATED);
		
	}

	@PutMapping("/updateUserRole/{id}")
	public ResponseEntity<UserRole> updateUserRole(@RequestBody UserRoleRequest userRoleRequest, @PathVariable Long id) throws UserNotExistsException {
		
		return new ResponseEntity<UserRole>(userRoleService.updateUserRole(userRoleRequest,id),HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteUserRole/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRoleService.deleteUserRole(id);
		return "deleted successfully";
	}

}
