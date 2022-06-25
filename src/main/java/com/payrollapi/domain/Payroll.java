package com.payrollapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Payroll {
	
	private String workerName;
	private String Description;
	private Double hourlyPrice;
	private Double workedHours;
	private Double totalPayment;

}
