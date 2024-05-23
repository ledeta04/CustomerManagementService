package com.craft.CustomerManagementService.SecurityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.craft.CustomerManagementService.JpaRepo.userRepo;
import com.craft.CustomerManagementService.Model.Users;

public class userDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	userRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> usersInfo = userRepo.findByUserName(username);
		
		
		return usersInfo.map(UserDetailsImpl :: new).orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}

}
