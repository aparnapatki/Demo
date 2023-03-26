package com.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Cart;
import com.inventory.model.CartItem;
import com.inventory.model.Company;
import com.inventory.model.Product;
import com.inventory.model.User;
import com.inventory.repository.CartItemRepository;
import com.inventory.repository.CartRepository;
import com.inventory.repository.CompanyRepository;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.UserRepository;
import com.inventory.request.CartItemRequest;
import com.inventory.request.CartRequest;
import com.inventory.request.CompanyRequest;

@Service
public class CartItemService {
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<CartItem> getAllCartItem() {
		
		return cartItemRepository.findAll();
	}

	public CartItem getCartItemById(Long id) {
		
		return cartItemRepository.findById(id).get();
	}

	public CartItem createCartItem(CartItemRequest cartItemRequest) {
		//System.out.println("Inside method");
		//System.out.println("UserId : "+cartItemRequest.getUserId());
		User user= userRepository.findById(cartItemRequest.getUserId()).get();
		Cart cart=cartRepository.findByUser(user);
		if(cart!=null) {
			//System.out.println("Inside if");
			cart = cartRepository.findByUser(user);
		}
		else {
			System.out.println("Inside else");
			Cart cartRequest = new Cart();
			cartRequest.setUser(user);
			cart = cartRepository.save(cartRequest);
			
		}
		Product product= productRepository.findById(cartItemRequest.getProductId()).get();
		
		CartItem cartItem= new CartItem();
		cartItem.setCart(cart);
		cartItem.setQuantity(cartItemRequest.getQuantity());
		cartItem.setPrice(cartItemRequest.getPrice());
		cartItem.setTotal(cartItemRequest.getQuantity() * cartItemRequest.getPrice());
		cartItem.setProduct(product);
		/*
		 * Cart cart = cartRepository.findById(cartItemRequest.getCartId()).get();
		 * cartItemRequest.setCartId(cart.getId()); cartItem.setCart(cart);
		 * cartItemRequest.setProductId(product.getId());
		 */
		
		if(cart.getCartItem() == null) {
			cart.setCartItem(new ArrayList<>());
		}
		
		cart.setGrandTotal(cart.getGrandTotal()+ cartItem.getTotal());
		
		cart.getCartItem().add(cartItem);
		cart.setTotalItem(cart.getCartItem().size());
		return cartItemRepository.save(cartItem);
		
	}

	public CartItem updateCartItem(CartItemRequest cartItemRequest, Long id) {
		
		
		return null;
	
		//return cartItemRepository.save(cartItem);
	}

	public void deleteCartItem(Long id) {
	    
		cartItemRepository.deleteById(id);
		
	}
	

}
