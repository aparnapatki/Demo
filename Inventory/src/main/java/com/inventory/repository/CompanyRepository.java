package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Company;
import com.inventory.model.User;
import com.inventory.request.CompanyRequest;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	Company findByName(String companyName);


	

}
