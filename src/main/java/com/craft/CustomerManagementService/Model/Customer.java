package com.craft.CustomerManagementService.Model;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
	
	@Id
	@GeneratedValue(generator = "customKeyGenerator")
    @GenericGenerator(name = "customKeyGenerator", strategy = "com.craft.CustomerManagementService.Utility.CustomKeyGenerator")
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	Address address;
	private String notes;
	CustomFields customFields;

}

