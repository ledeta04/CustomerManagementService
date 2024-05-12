package com.craft.CustomerManagementService.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteCustomerDto {
	
	private String message;
	private String statusCode;

}
