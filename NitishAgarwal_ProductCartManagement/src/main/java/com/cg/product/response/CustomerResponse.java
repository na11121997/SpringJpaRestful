package com.cg.product.response;

//response class created to have the status code and error message if error/exception occurs
public class CustomerResponse {
	private String errorMessage;
	private int statusCode;
	public CustomerResponse(String errorMessage, int statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}
	public CustomerResponse() {
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
