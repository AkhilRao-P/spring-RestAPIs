package com.flm.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flm.dto.ErrorMessage;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = ProductNotFoundException.class)
	public ResponseEntity handleProductNotFoundException(ProductNotFoundException ex) {
		ErrorMessage message = new ErrorMessage(ex.getMessage(),new Date(),HttpStatus.NOT_FOUND.name());
		log.error("I am in handleProductNotFoundException()");
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(exception = RuntimeException.class)
	public ResponseEntity handleRuntimeException(RuntimeException ex) {
		ErrorMessage message = new ErrorMessage(ex.getMessage(),new Date(),HttpStatus.INTERNAL_SERVER_ERROR.name());
		log.error("I am in handleRuntimeException()");
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(exception = ArrayIndexOutOfBoundsException.class)
	public ResponseEntity handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
		ErrorMessage message = new ErrorMessage(ex.getMessage(),new Date(),HttpStatus.INTERNAL_SERVER_ERROR.name());
		log.error("I am in handleArrayIndexOutOfBoundsException()");
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity handleException(Exception ex) {
		ErrorMessage message = new ErrorMessage(ex.getMessage(),new Date(),HttpStatus.INTERNAL_SERVER_ERROR.name());
		log.error("I am in handleException()");
		return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
