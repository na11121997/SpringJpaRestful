package com.cg.product.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.product.exceptions.ProductDetailsNotFoundException;
import com.cg.product.response.CustomerResponse;

@ControllerAdvice 
public class ProductExceptionAspect {
	  @ExceptionHandler(ProductDetailsNotFoundException.class)	//handles the exception ProductDetailsNotFoundException
	    public ResponseEntity<CustomerResponse> handleAssociateDetailsNotFoundException(Exception e){
	        CustomerResponse response= new CustomerResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
	        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED); // returns the status code , exception message       
	    }
}
