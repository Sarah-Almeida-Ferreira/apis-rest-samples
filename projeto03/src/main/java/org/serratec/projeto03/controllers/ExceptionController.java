package org.serratec.projeto03.controllers;

import org.serratec.projeto03.exceptions.InsufficientFundsException;
import org.serratec.projeto03.exceptions.ItemAlreadyExistsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
		return ResponseEntity.notFound().header("x-erro-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<String> handleItemAlreadyExistsException(ItemAlreadyExistsException exception) {
		return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	}
	
	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<String> handleInsufficientFundsException(InsufficientFundsException exception) {
		return ResponseEntity.badRequest().header("x-erro-msg", exception.getMessage()).build();
	}
	
	
}
