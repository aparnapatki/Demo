package com.inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.Response.OrderResponse;
import com.inventory.Response.UserRoleResponse;
import com.inventory.model.Order;
import com.inventory.model.User;
import com.inventory.model.UserRole;
import com.inventory.repository.OrderRepository;
import com.inventory.repository.UserRepository;
import com.inventory.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	public List<OrderResponse> getAllOrder() {

		List<Order> list = orderRepository.findAll();
		List<OrderResponse> response = new ArrayList<>();

		for (Order o : list) {

			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setId(o.getId());

			response.add(orderResponse);

		}
		return response;
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).get();
	}

	public Order createOrder(OrderRequest orderRequest) {

		Order order = new Order();
		order.setType(orderRequest.getType());
		order.setStatus(orderRequest.getStatus());
		order.setTotal(orderRequest.getTotal());
		order.setShippingCharges(orderRequest.getShippingCharges());
		order.setDiscount(orderRequest.getDiscount());
		order.setTax(orderRequest.getTax());
		order.setGrandTotal(orderRequest.getGrandTotal());

		User user = userRepository.findById(orderRequest.getUserId()).get();
		orderRequest.setUserId(user.getId());
		order.setUser(user);
		return orderRepository.save(order);
	}

	public Order updateOrder(OrderRequest orderRequest, Long id) {

		Order order = new Order();
		order.setType(orderRequest.getType());
		order.setStatus(orderRequest.getStatus());
		order.setTotal(orderRequest.getTotal());
		order.setShippingCharges(orderRequest.getShippingCharges());
		order.setDiscount(orderRequest.getDiscount());
		order.setTax(orderRequest.getTax());
		order.setGrandTotal(orderRequest.getGrandTotal());

		return orderRepository.save(order);
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);

	}

	public Order getOrderByUserId(Long id) {

		Optional<User> user = userRepository.findById(id);
		System.out.println("id" + user);
		if (user.isPresent()) {
			return orderRepository.findByUser(user.get());
		}
		System.out.println("id" + user);
		throw new RuntimeException("User not found for id" + id);

	}

}
