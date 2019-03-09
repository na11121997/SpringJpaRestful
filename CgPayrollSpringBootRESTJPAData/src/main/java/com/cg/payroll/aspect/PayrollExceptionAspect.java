package com.cg.payroll.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.payroll.exception.AssociateDetailNotfoundException;
import com.cg.payroll.response.CustomerResponse;

@ControllerAdvice
public class PayrollExceptionAspect {
	
	  @ExceptionHandler(AssociateDetailNotfoundException.class)
	    public ResponseEntity<CustomerResponse> handleAssociateDetailsNotFoundException(Exception e){
	        CustomerResponse response= new CustomerResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
	        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	        
	    }


}
