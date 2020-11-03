package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Aditya Ghogale
 *
 */
@ControllerAdvice
public class LoginExceptionController extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception, WebRequest webRequest){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("Invalid user credentials!!Please provide proper details");
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
