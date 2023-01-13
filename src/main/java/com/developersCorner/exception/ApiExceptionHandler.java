package com.developersCorner.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value = { ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z")));

		return new ResponseEntity<Object>(apiException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {DataIntegrityViolationException.class})
	public ResponseEntity<Object> handleConflict(ApiRequestException e) {
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.CONFLICT, ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<Object>(apiException, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = {ResourceNotFoundException.class})
	public ResponseEntity<Object> handleResourceNotFoundException(ApiRequestException e) {
		ApiException apiException = new ApiException(e.getMessage(), e, HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<Object>(apiException, HttpStatus.NOT_FOUND);
	}
}
