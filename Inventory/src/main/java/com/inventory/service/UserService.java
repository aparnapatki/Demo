package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inventory.model.User;
import com.inventory.model.UserRole;
import com.inventory.repository.UserRepository;
import com.inventory.repository.UserRoleRepository;
import com.inventory.request.UserRequest;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {

		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("User not found for id" + id);
	}

	public User createUser(UserRequest userRequest) throws Exception {

		/*
		 * ModelMapper model = new ModelMapper(); User user = new User();
		 * model.map(userRequest, user);
		 * 
		 * UserRole role = userRoleRepository.findById(userRequest.getRoleId()).get();
		 * 
		 * userRequest.setRoleId(role.getId()); user.setUserRole(role);
		 */
		User user = new User();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setMiddleName(userRequest.getMiddleName());
		user.setUserName(userRequest.getUserName());
		user.setPassword(userRequest.getPassword());
		user.setEmail(userRequest.getEmail());
		user.setMobileNo(userRequest.getMobileNo());
		UserRole role;
		if (userRequest.getRoleId() > 0 && userRequest.getRoleId() != null && userRequest.getRoleId() < 3) {
			role = userRoleRepository.findById(userRequest.getRoleId()).get();

		} else {
			// role = userRoleRepository.findById(2L).get();
			throw new Exception("User Role not exists with id : " + userRequest.getRoleId());
		}

		user.setUserRole(role);
		return userRepository.save(user);

	}

	public User updateUser(UserRequest userRequest, Long id) {

		//User user = userRepository.findById(id).get();
		if(userRepository.findById(id).isPresent()) {
			User user = userRepository.findById(id).get();
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setMiddleName(userRequest.getMiddleName());
		user.setUserName(userRequest.getUserName());
		user.setPassword(userRequest.getPassword());
		user.setEmail(userRequest.getEmail());
		return userRepository.save(user);
		}
		else {
			throw new RuntimeException("User not exists with id : " + id);
		}
		
	}

	public void deleteUser(Long id) {
		if(userRepository.existsById(id)){
		userRepository.deleteById(id);

	}
		else {
			throw new RuntimeException("User not exists with id : " + id);
		}
	}
}
