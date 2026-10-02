package com.amazon.order.exception;

public class OrderDoesNotExistsException extends RuntimeException {

	public OrderDoesNotExistsException(String message) {
		super(message);

	}
}