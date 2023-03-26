package com.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message= "Name should not null")
	//@Column(name = "name", length = 30, nullable = false, unique = true)
	private String name;
	
	public UserRole() {
		super();
	}
	
	public UserRole(Long id, @NotNull(message = "Name should not null") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @OneToMany(mappedBy = "userRole") List<User> user;
	 * 
	 * public List<User> getUser() { return user; }
	 * 
	 * public void setUser(List<User> user) { this.user = user; }
	 */
	
}
