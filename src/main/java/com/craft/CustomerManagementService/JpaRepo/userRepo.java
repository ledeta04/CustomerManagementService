package com.craft.CustomerManagementService.JpaRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.CustomerManagementService.Model.Users;


@Repository
public interface userRepo extends JpaRepository<Users, Integer> {
	
	public Optional<Users> findByUserName(String username);

}
