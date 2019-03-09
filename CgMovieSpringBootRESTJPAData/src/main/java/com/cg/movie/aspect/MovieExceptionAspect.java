package com.cg.movie.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.response.CustomerResponse;

@ControllerAdvice
public class MovieExceptionAspect {
	
	  @ExceptionHandler(MovieNotFoundException.class)
	    public ResponseEntity<CustomerResponse> handleAssociateDetailsNotFoundException(Exception e){
	        CustomerResponse response= new CustomerResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
	        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	        
	    }


}
