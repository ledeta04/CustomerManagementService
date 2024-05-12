package com.craft.CustomerManagementService.JpaRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.craft.CustomerManagementService.Model.Customer;


@Repository
public interface customerRepo extends CrudRepository<Customer, String>{

	
}

