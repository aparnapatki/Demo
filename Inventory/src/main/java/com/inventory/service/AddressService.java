package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Address;
import com.inventory.model.User;
import com.inventory.repository.AddressRepository;
import com.inventory.repository.UserRepository;
import com.inventory.request.AddressRequest;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	public Address getAddressById(Long id) {
		
		return addressRepository.findById(id).get();
	}
	public Address createAddress(AddressRequest addressRequest) {
		
		Address address= new Address();
		User user= userRepository.findById(addressRequest.getUserId()).get();
		
		address.setfName(addressRequest.getfName());
		address.setlName(addressRequest.getlName());
		address.setMobileNo(addressRequest.getMobileNo());
		address.setEmail(addressRequest.getEmail());
		address.setCity(addressRequest.getCity());
		address.setCountry(addressRequest.getCountry());
		address.setAddressline1(addressRequest.getAddressline1());
		address.setUser(user);
		return addressRepository.save(address);
	}

	public Address updateAddress(AddressRequest addressRequest, Long id) {
		return null;
		
//		/return addressRepository.save(addressRequest);
	}

	public void deleteAddress(Long id) {
		addressRepository.deleteById(id);
	}

}
