package com.craft.CustomerManagementService.Service;

import com.craft.CustomerManagementService.Dto.CustomerDto;
import com.craft.CustomerManagementService.Dto.DeleteCustomerDto;
import com.craft.CustomerManagementService.Model.Customer;

public interface customerService {
	
	public CustomerDto addCustomer(Customer customer);
	public CustomerDto updateCustomer(String customerId , Customer customer);
	public Customer retrieveCustomerById(String customerId);
	public DeleteCustomerDto deleteCustomerById(String customerId);


}
