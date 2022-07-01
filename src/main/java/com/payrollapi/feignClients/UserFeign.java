package com.payrollapi.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.payrollapi.domain.User;

@FeignClient(name="user-api", url ="http://localhost:8080")
public interface UserFeign {
	//inserir um contrato dos metodos de listar e findbyid de user-api:
	@GetMapping
	public ResponseEntity<List<User>> findAll();
		
		
	
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById( @PathVariable Long id);

}
