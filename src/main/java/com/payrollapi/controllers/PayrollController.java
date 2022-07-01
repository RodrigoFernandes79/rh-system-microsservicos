package com.payrollapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapi.domain.Payroll;
import com.payrollapi.domain.User;
import com.payrollapi.feignClients.UserFeign;

@RestController
@RequestMapping("/payments")
public class PayrollController {
	
	@Autowired
	private UserFeign userFeign;
	
	@GetMapping("/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
		
		User user = userFeign.findById(workerId).getBody();
		
		return ResponseEntity.ok().body(
				new Payroll(user.getName(),
						payment.getDescription(),
						user.getHourlyPrice(),
						payment.getWorkedHours(),
						user.getHourlyPrice()*payment.getWorkedHours())
				);
		
	}

}
