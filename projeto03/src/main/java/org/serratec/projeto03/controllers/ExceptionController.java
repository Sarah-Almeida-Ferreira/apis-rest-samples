package org.serratec.projeto03.controllers;

import org.serratec.projeto03.exceptions.CpfAlreadyExistsException;
import org.serratec.projeto03.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException exception) {
		return ResponseEntity.notFound().header("x-erro-msg", exception.getMessage()).build();
	}

	@ExceptionHandler(CpfAlreadyExistsException.class)
	public ResponseEntity<String> handleCpfAlreadyExistsException(CpfAlreadyExistsException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
	}
}
