package com.jparelation.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	public void getMessage() {
		System.out.println("Hello");
	}
	

}
