package com.craft.CustomerManagementService.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.CustomerManagementService.Model.Users;


@Repository
public interface userRepo extends JpaRepository<Users, Integer> {
	
	

}
