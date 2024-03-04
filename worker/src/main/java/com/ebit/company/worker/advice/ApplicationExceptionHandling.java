package com.ebit.company.worker.advice;

import java.util.*;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandling {

	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();
		
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String getFieldName = ((FieldError) error).getField();
			String getMessage = error.getDefaultMessage();
			errorMap.put(getFieldName, getMessage);
		});
		return errorMap;
	}
}
