package com.inventory.service;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.inventory.Response.UserRoleResponse;
import com.inventory.model.User;
import com.inventory.model.UserRole;
import com.inventory.repository.UserRepository;
import com.inventory.repository.UserRoleRepository;
import com.inventory.request.UserRoleRequest;

@Service
public class UserRoleService {
	
	@Autowired
	UserRoleRepository userRoleRepository;

	public List<UserRoleResponse> getAllUserRole() {
		List<UserRole> list= userRoleRepository.findAll();
		List<UserRoleResponse> response= new ArrayList<>();
	
		for(UserRole u : list) {
			
			UserRoleResponse roleResponse= new UserRoleResponse();
			
			roleResponse.setId(u.getId());
			roleResponse.setName(u.getName());
			response.add(roleResponse);
			
		}
		return response;
		}
	
	public UserRole getUserRoleById(Long id) {
		 Optional<UserRole> role= userRoleRepository.findById(id);
		if(role.isPresent()){
		return role.get();	
		}
		throw new RuntimeException("Employee is not found for id" +id);
		 
	}

	public UserRole createUserRole(UserRoleRequest userRoleRequest) {
		UserRole role = new UserRole();
		role.setName(userRoleRequest.getName());
		return userRoleRepository.save(role);
	}

	public UserRole updateUserRole(UserRoleRequest userRoleRequest,Long id) {
		
		UserRole role= userRoleRepository.findById(id).get();
		if(userRoleRepository.existsById(id)) {
		role.setName(userRoleRequest.getName());
		}
		
		return userRoleRepository.save(role);
	}

	public void deleteUserRole(Long id) {
	
			userRoleRepository.deleteById(id);
		
	}

	public void addDefaultRoles() {
		UserRole admin = new UserRole(1l, "Admin");
		UserRole user = new UserRole(2l, "User");
		
		if(userRoleRepository.count() == 0) {
			userRoleRepository.saveAll(Arrays.asList(admin,user));
		}	
	}
}
