package com.demo.productservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.productservice.customexceptions.ProductNotFoundException;
import com.demo.productservice.dtos.ExceptionDto;

@ControllerAdvice
public class ControllerAdvices {

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody()
	private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException) {

		ExceptionDto exceptionDto = new ExceptionDto();

		exceptionDto.setMessage(productNotFoundException.getMessage());

		return exceptionDto;
	}
}
