package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.Cart;
import com.inventory.model.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	boolean existsByUserId(User user);

	Cart findByUserId(User user);

	Cart findByUser(User user);

	boolean existsByUserId(Long userId);


}
