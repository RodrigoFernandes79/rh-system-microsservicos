package com.payrollapi.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.payrollapi.domain.Payroll;
import com.payrollapi.domain.User;
import com.payrollapi.feignClients.UserFeign;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PayrollService {
	
	
	
	@Autowired
	private UserFeign userFeign;
	@Autowired
	private Environment env;

	public Payroll getPayment(Long workerId, Payroll payment) {
		log.info("PAYROLL_SERVICE ::: Get request on "+ env.getProperty("server.port") + "PORT");
		try {
		User user = userFeign.findById(workerId).getBody();
		if(Objects.nonNull(user)) {
			return new Payroll(user.getName(),
					payment.getDescription(),
					user.getHourlyPrice(),
					payment.getWorkedHours(),
					user.getHourlyPrice()*payment.getWorkedHours());
			
		}		
		}catch(RuntimeException ex) {
			
			throw new RuntimeException("Objeto Não Encontrado!!");
		}
		return null;
	}
	
	

}
