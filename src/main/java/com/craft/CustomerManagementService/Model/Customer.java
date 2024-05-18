package com.craft.CustomerManagementService.Model;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
	@NotEmpty(message = "first name can not be empty")
	private String firstName;
	@NotEmpty(message = "last name can not be empty")
	private String lastName;
	@NotEmpty(message = "email can not be empty")
	private String email;
	private String phone;
	
	Address address;
	private String notes;
	CustomFields customFields;

}

