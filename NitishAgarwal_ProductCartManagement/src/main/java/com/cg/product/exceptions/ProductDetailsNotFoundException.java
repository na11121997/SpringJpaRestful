package com.cg.product.exceptions;
//extends the Runtime Exception Class 
public class ProductDetailsNotFoundException extends RuntimeException{

	public ProductDetailsNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ProductDetailsNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
