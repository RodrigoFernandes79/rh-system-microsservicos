package com.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter  @Setter
public class User {
	
	
	private Long id;
	
	private String name;
	private String password;
	private String email;
	private Double hourlyPrice;

	

}
