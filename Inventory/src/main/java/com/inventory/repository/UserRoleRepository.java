package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


}
