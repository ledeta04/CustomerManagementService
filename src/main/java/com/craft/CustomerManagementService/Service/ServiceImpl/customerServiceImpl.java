package com.craft.CustomerManagementService.Service.ServiceImpl;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.craft.CustomerManagementService.Dto.CustomerDto;
import com.craft.CustomerManagementService.Dto.DeleteCustomerDto;
import com.craft.CustomerManagementService.Dto.Leads;
import com.craft.CustomerManagementService.JpaRepo.customerRepo;
import com.craft.CustomerManagementService.Model.Address;
import com.craft.CustomerManagementService.Model.CustomFields;
import com.craft.CustomerManagementService.Model.Customer;
import com.craft.CustomerManagementService.Service.customerService;


@Service
public class customerServiceImpl implements customerService {
	
	
	@Autowired
	customerRepo customerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ModelMapper modelMapper;
	
	private final String url = "http://localhost:9094/leads/convert";
	

	@Override
	public CustomerDto addCustomer(Customer customer) {
		
		try {
			
			customerRepo.save(customer);
			
			CustomerDto customerDto = new CustomerDto(customer, "Customer added successfully", "1000");
			
			return customerDto;
			
		} catch (Exception e) {

			CustomerDto customerDto = new CustomerDto(null, "Customer are not added", "2000");
			
			return customerDto;
			
		}
		
	}


	@Override
	public CustomerDto updateCustomer(String customerId, Customer customer) {
		
			
			Optional<Customer> optional = customerRepo.findById(customerId);
			
			if(optional.isPresent()) {
				
			Customer customer2 = optional.get();
			

			customer2.setFirstName(customer.getFirstName());
			customer2.setLastName(customer.getLastName());
			customer2.setNotes(customer.getNotes());
			customer2.setPhone(customer.getPhone());
			
			Address address = new Address();
			
			address.setStreet(customer.getAddress().getStreet());
			address.setCity(customer.getAddress().getCity());
			address.setState(customer.getAddress().getState());
			address.setZipcode(customer.getAddress().getZipcode());
			
			CustomFields customFields = new CustomFields();
			
			customFields.setBirthday(customer.getCustomFields().getBirthday());
			customFields.setCompany(customer.getCustomFields().getCompany());
			
			customer2.setAddress(address);
			customer2.setCustomFields(customFields);
			
			customerRepo.save(customer2);
			
			CustomerDto customerDto = new CustomerDto(customer, "Successfully Updated", "3000");
			
			return customerDto;
			
		}	
			return null;
	}
	

	@Override
	public Customer retrieveCustomerById(String customerId) {
		
		
		Customer customer  = customerRepo.findById(customerId).get();
		
		return customer;
		
	}


	@Override
	public DeleteCustomerDto deleteCustomerById(String customerId) {
		
		try {
			
			Optional<Customer> optional =  customerRepo.findById(customerId);
			
			customerRepo.deleteById(customerId);
			
			if(optional.isPresent()) {
				
				return new DeleteCustomerDto("Customer deleted Successfully", "400");
			
		} 
			else {
			
			return new DeleteCustomerDto("Customer not found", "420");
		}
		}
			catch (Exception e) {

			return new DeleteCustomerDto("Error deleting Customer", "450");
			
  }
}


	@Override
	public Leads convertLeadsToCustomers(String leadId , Leads leads) {
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Leads> requestEntity = new HttpEntity<>(leads, headers);
		
		ResponseEntity<Leads> responseEntity = restTemplate.exchange(
				
				url, 
				HttpMethod.PUT, 
				requestEntity, 
				Leads.class);
		
		if(responseEntity.getStatusCode().is2xxSuccessful()) {
			
			return responseEntity.getBody();
			
		}else {
			
			return null;
		}
	}


	@Override
	public Iterable<Customer> getAllCustomers() {

	     customerRepo.findAll();
	     
	     return customerRepo.findAll();
	}

}