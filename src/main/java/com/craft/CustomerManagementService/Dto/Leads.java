package com.craft.CustomerManagementService.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leads {
	
	private String leadId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String company;
	private String status;
	private String source;
	
	CustomFields customFields;

}
