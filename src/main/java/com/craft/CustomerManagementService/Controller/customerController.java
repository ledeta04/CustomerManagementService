package com.craft.CustomerManagementService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.CustomerManagementService.Model.Customer;
import com.craft.CustomerManagementService.Service.customerService;

  

@RestController
@RequestMapping("/customers")
public class customerController {
	
	@Autowired 
	customerService customerService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		
	
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("customerId") String customerId , @RequestBody Customer customer){
		
		try {
			
			return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/get/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") String customerId){
		
		return new ResponseEntity<> (customerService.retrieveCustomerById(customerId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") String customerId){
		
		try {
			return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.NOT_FOUND);
		}
	}
}
