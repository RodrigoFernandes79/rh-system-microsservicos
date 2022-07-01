package com.payrollapi.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException {
	
	private LocalDateTime timestamp;
	private String mensagem;
	private Integer status;
	private String path;
	
	
	
	

}
