package com.amazon.customer.exception;

public class CustomerNotFoundExeption extends RuntimeException{
	
	public CustomerNotFoundExeption(String message) {
		super(message);
	}
}