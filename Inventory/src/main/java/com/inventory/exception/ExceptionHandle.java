package com.inventory.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandle extends ResponseEntityExceptionHandler{
	
	/*
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) {
	 * 
	 * Map<String,Object> map= new HashMap<>(); map.put("timestamp",
	 * System.currentTimeMillis()); map.put("status", status.value());
	 * 
	 * List<String> errors= ex.getBindingResult().getFieldErrors().stream().map(x ->
	 * x.getDefaultMessage()).collect(Collectors.toList()); map.put("errors",
	 * errors); return new ResponseEntity<Object>(map,status); }
	 */

}
