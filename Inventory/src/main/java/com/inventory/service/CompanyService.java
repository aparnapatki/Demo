package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Company;
import com.inventory.model.User;
import com.inventory.repository.CompanyRepository;
import com.inventory.request.CompanyRequest;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;

	public List<Company> getAllCompany() {
		
		return companyRepository.findAll();
	}

	public Company getCompanyById(Long id) {
		
		return companyRepository.findById(id).get();
	}

	public Company createCompany(CompanyRequest companyRequest) {
		
		/*
		 * Company company= new Company(); ModelMapper model = new ModelMapper();
		 * model.map(companyRequest, company); return companyRepository.save(company);
		 */
		
		Company company= new Company();
		company.setName(companyRequest.getName());
		company.setDescription(companyRequest.getDescription());
		return companyRepository.save(company);
	}

	public Company updateCompany(CompanyRequest companyRequest,Long id) {
		Company company= companyRepository.findById(id).get();
		company.setName(companyRequest.getName());
		company.setDescription(companyRequest.getDescription());
	
		return companyRepository.save(company);
	}

	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
		
	}

}
