package com.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inventory.service.UserRoleService;

@SpringBootApplication
public class InventoryApplication implements CommandLineRunner {

	@Autowired
	private UserRoleService userRoleService;
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
	
		userRoleService.addDefaultRoles();
	}
      
}
