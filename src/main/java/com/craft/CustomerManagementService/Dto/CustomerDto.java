package com.craft.CustomerManagementService.Dto;

import com.craft.CustomerManagementService.Model.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
	
	private Customer customer;
	private String message;
	private String statusCode;

}
