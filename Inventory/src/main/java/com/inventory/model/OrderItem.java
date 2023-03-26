package com.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class OrderItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private int price;
   private double discount;
   private int quantity;

	
	public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public double getDiscount() {
	return discount;
}


public void setDiscount(double discount) {
	this.discount = discount;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public Product getProduct() {
	return product;
}


public void setProduct(Product product) {
	this.product = product;
}


public Order getOrder() {
	return order;
}


public void setOrder(Order order) {
	this.order = order;
}


	@ManyToOne
	@JoinColumn(name="prod_Id", referencedColumnName = "id")
	private Product product;
	

	@ManyToOne
	@JoinColumn(name="order_Id", referencedColumnName = "id")
	private Order order;
}
