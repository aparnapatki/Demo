package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Order;
import com.inventory.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findByUser(User user);
	

}
