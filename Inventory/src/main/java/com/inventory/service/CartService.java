package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Cart;
import com.inventory.model.Company;
import com.inventory.model.User;
import com.inventory.repository.CartRepository;
import com.inventory.repository.CompanyRepository;
import com.inventory.repository.UserRepository;
import com.inventory.request.CartRequest;
import com.inventory.request.CompanyRequest;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;

	@Autowired
	UserRepository userRepository;

	public List<Cart> getAllCart() {

		return cartRepository.findAll();
	}

	public Cart getCartById(Long id) {

		return cartRepository.findById(id).get();
	}

	public Cart createCart(CartRequest cartRequest) throws Exception {
		
		if (cartRepository.existsByUserId(cartRequest.getUserId())) {
			throw new Exception("id  is present");
		}
		Cart cart = new Cart();
		cart.setTotal(cartRequest.getTotal());
		cart.setDiscount(cartRequest.getDiscount());
		cart.setTax(cartRequest.getTax());
		cart.setGrandTotal(cartRequest.getGrandTotal());
		User user = userRepository.findById(cartRequest.getUserId()).get();

		cartRequest.setUserId(user.getId());
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	public Cart updateCart(CartRequest cartRequest, Long id) {
		
		
		Cart cart = new Cart();
		cart.setTotal(cartRequest.getTotal());
		cart.setDiscount(cartRequest.getDiscount());
		cart.setTax(cartRequest.getTax());
		cart.setGrandTotal(cartRequest.getGrandTotal());
		User user = userRepository.findById(cartRequest.getUserId()).get();
		cartRequest.setUserId(user.getId());
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	public void deleteCart(Long id) {
		
		cartRepository.deleteById(id);

	}

	public Cart getCartByUserId(Long id) {

		Optional<User> user = userRepository.findById(id);
		System.out.println("id" + user);
		if (user.isPresent()) {
			return cartRepository.findByUser(user.get());
		}
		System.out.println("id" + user);
		throw new RuntimeException("User not found for id" + id);

	}

}
