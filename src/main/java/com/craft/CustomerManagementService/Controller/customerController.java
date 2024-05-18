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

import com.craft.CustomerManagementService.Dto.CustomerDto;
import com.craft.CustomerManagementService.Dto.Leads;
import com.craft.CustomerManagementService.Model.Customer;
import com.craft.CustomerManagementService.Model.Users;
import com.craft.CustomerManagementService.Service.customerService;
import com.craft.CustomerManagementService.Service.userService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;

  

@RestController
@RequestMapping("/customers")
public class customerController {
	
	@Autowired 
	customerService customerService;
	
	@Autowired
	userService userService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> addCustomer(@RequestBody @Valid Customer customer){
		
		try {
			return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
			
		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("customerId")@Valid String customerId , @RequestBody Customer customer){
		
		try {
			
			return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{customerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId")@Valid String customerId){
		
		try {
			return new ResponseEntity<> (customerService.retrieveCustomerById(customerId), HttpStatus.OK);
			
		} catch (Exception e) {
			
			CustomerDto customerDto = CustomerDto.builder()
					
					.message(e.getMessage())
					.statusCode("555")
					.build();

			return new ResponseEntity<> (customerDto, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId")@Valid String customerId){
		
		try {
			return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
//			return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/convert/{leadId}")
	
	@CircuitBreaker(name = "convertLeadToCustomerCircuitBreadker" , fallbackMethod = "convertfallbackMethod")
	public ResponseEntity<?> convertLeadsToCustomers(@PathVariable("leadId")@Valid String leadId , @RequestBody Leads leads ){
		
		return new ResponseEntity<>(customerService.convertLeadsToCustomers(leadId, leads), HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<?> convertfallbackMethod(String leadId, Leads leads, Exception exception){
		
		return new ResponseEntity<>(exception.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/getAll")
	ResponseEntity<?> getAllCustomer(){
		
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Users users){
		
		return new ResponseEntity<>(userService.addUser(users), HttpStatus.ACCEPTED);
	}

}
