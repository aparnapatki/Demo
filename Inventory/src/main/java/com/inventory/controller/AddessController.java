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

import com.inventory.model.Address;
import com.inventory.model.UserRole;
import com.inventory.request.AddressRequest;
import com.inventory.service.AddressService;

@RestController
public class AddessController {
	
	@Autowired
	AddressService addressService;
	

	@GetMapping("/getAllAddress")
	public ResponseEntity<List<Address>> getAllAddress(){
		
		return new ResponseEntity<List<Address>>(addressService.getAllAddress(), HttpStatus.OK);	
	}
	@GetMapping("/getAddressById/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long id){
		
		return new ResponseEntity<Address>(addressService.getAddressById(id), HttpStatus.OK);	
	}
	@PostMapping("/createAddress")
	public ResponseEntity<Address> createAddress(@RequestBody AddressRequest addressRequest) {
		return new ResponseEntity<Address>(addressService.createAddress(addressRequest), HttpStatus.CREATED);
		
	}

	@PutMapping("/updateAddress/{id}")
	public ResponseEntity<Address> updateAddress(@RequestBody AddressRequest addressRequest, @PathVariable Long id) {
		return new ResponseEntity<Address>(addressService.updateAddress(addressRequest,id), HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteAddress/{id}")
	public String deleteAddress(@PathVariable Long id) {
		addressService.deleteAddress(id);
		return "deleted successfully";
	}

}
