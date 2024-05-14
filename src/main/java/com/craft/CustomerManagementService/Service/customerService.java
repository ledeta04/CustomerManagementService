package com.craft.CustomerManagementService.Service;



import com.craft.CustomerManagementService.Dto.CustomerDto;
import com.craft.CustomerManagementService.Dto.DeleteCustomerDto;
import com.craft.CustomerManagementService.Dto.Leads;
import com.craft.CustomerManagementService.Model.Customer;

public interface customerService {
	
	public CustomerDto addCustomer(Customer customer);
	public CustomerDto updateCustomer(String customerId , Customer customer);
	public Customer retrieveCustomerById(String customerId);
	public Iterable<Customer>  getAllCustomers();
	public DeleteCustomerDto deleteCustomerById(String customerId);
	public Leads convertLeadsToCustomers(String leadId , Leads leads);


}
