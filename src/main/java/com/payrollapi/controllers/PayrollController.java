package com.payrollapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payrollapi.domain.Payroll;
import com.payrollapi.services.PayrollService;

@RestController
@RequestMapping("/payments")
public class PayrollController {
	
	@Autowired
	private PayrollService payrollService;
	
	@GetMapping("/{workerId}")
	public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment){
		
		Payroll obj = payrollService.getPayment(workerId,payment);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
