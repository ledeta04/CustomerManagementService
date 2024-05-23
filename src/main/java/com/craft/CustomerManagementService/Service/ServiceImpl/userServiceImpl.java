package com.craft.CustomerManagementService.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.craft.CustomerManagementService.JpaRepo.userRepo;
import com.craft.CustomerManagementService.Model.Users;
import com.craft.CustomerManagementService.Service.userService;


@Service
public class userServiceImpl implements userService {
	
	@Autowired
	userRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public String addUser(Users users) {
		
		
		try {
			
			users.setPassword(passwordEncoder.encode(users.getPassword()));
			
			userRepo.save(users);
			
			return "Customer is registered";
			
		} catch (Exception e) {

			return e.getMessage();
			
		}
	}

}
