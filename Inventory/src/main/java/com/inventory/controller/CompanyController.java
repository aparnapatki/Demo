package com.inventory.controller;

import java.util.List;

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

import com.inventory.model.Company;
import com.inventory.request.CompanyRequest;
import com.inventory.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/getAllCompany")
	public ResponseEntity<List<Company>> getAllCompany(){
		
		return new ResponseEntity<>(companyService.getAllCompany(),HttpStatus.OK);	
	}

	@GetMapping("/getCompanyById/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		
		return new ResponseEntity<Company>(companyService.getCompanyById(id) ,HttpStatus.OK);	
	}
	@PostMapping("/createCompany")
	public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyRequest companyRequest) {
		return new ResponseEntity<Company>(companyService.createCompany(companyRequest) ,HttpStatus.CREATED);
		
	}

	@PutMapping("/updateCompany/{id}")
	public ResponseEntity<Company> updateCompany(@RequestBody CompanyRequest companyRequest, @PathVariable Long id) {
		return new ResponseEntity<Company>(companyService.updateCompany(companyRequest, id) ,HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteCompany/{id}")
	public String deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return "deleted successfully";
	}


}
